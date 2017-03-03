package com.ioc.util;
import java.beans.Introspector;  
import java.beans.PropertyDescriptor;  
import java.lang.reflect.Method;  
import java.net.URL;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlLoader {
	 // xml所有的属性  
    private ArrayList<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();  
    // xml中所有的bean  
    private Map<String, Object> sigletons = new HashMap<String, Object>();  
    
  
    public ClassPathXmlLoader(String file) {
    	super();
//  1 	读取beans.xml中的所有数据到数组中
		readXml(file);  
//	2 	初始化所有的bean类	
        instanceBeans(); 
//  3  	链接生成的所有bean的所有属性  
        instanceObject();
	}



	/** 
     * 注入 
     */  
    private void instanceObject() {  
        for (BeanDefinition beanDefinition : beanDefinitions) {  
            //判断有没有注入属性  
            if (beanDefinition.getProperty() != null) {  
                Object bean = sigletons.get(beanDefinition.getId());  
                if (bean != null) {  
                    try {  
                        //得到被注入bean的所有的属性  
                        PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();  
                        //得到所有的注入bean属性  
                        for(PropertyDefinition propertyDefinition:beanDefinition.getProperty()){  
                            for(PropertyDescriptor propertyDescriptor:ps){  
                                if(propertyDescriptor.getName().equals(propertyDefinition.getName())){  
                                    Method setter = propertyDescriptor.getWriteMethod();//获取set方法  
                                    if(setter!=null){  
                                        setter.setAccessible(true);//得到private权限  
                                        //注入已经初始化后的属性  
                                        setter.invoke(bean, sigletons.get(propertyDefinition.getRef()));  
                                    }  
                                    break;  
                                }  
                            }  
                        }  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
  
    /** 
     * 实例所有的bean 
     */  
    private void instanceBeans() {  
        for (int i = 0; i < beanDefinitions.size(); i++) {  
            BeanDefinition bd = beanDefinitions.get(i);  
            try {  
                try {  
                    if (bd.getClassName() != null  
                            && !bd.getClassName().equals(""))  
//                    	将beanDefinitions中的bean 全部初始化并放入字典中
                        sigletons.put(bd.getId(), Class.forName(  
                                bd.getClassName()).newInstance());  
                } catch (InstantiationException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (IllegalAccessException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            } catch (ClassNotFoundException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /** 
     * 读xml 
     *  
     * @param file 
     */  
    private void readXml(String file) {  
        try {  
//        	 使用SAX方式解析XML
            SAXReader reader = new SAXReader();   
//            获取加载文件路径
            URL xmlPath = this.getClass().getClassLoader().getResource(file);  
            Document doc = reader.read(xmlPath);  
//          取得根节点  
            Element root = doc.getRootElement(); 
//            获取所有根节点下的子节点
            List<Element> beans = root.elements();
//            遍历所有子节点
            for (Element element : beans) {  
                String id = element.attributeValue("id");// id;  
                String clazz = element.attributeValue("class");  
                BeanDefinition bd = new BeanDefinition(id, clazz);  
                // 读取子节点中的子属性
                if (element.hasContent()) {  
                    List<Element> propertys = element.elements();  
                    for (Element property : propertys) {  
                        String name = property.attributeValue("name");  
                        String ref = property.attributeValue("ref");  
                        PropertyDefinition pd = new PropertyDefinition(name,  
                                ref);  
//                        设置子属性到数组
                        bd.getProperty().add(pd);  
                    }  
                } 
//                将子节点添加到bean数组中
                beanDefinitions.add(bd);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
        }  
    }  
  
    /** 
     * 通过名字得到bean 
     *  
     * @param str 
     * @return 
     */  
    public Object getBean(String str) {  
        return sigletons.get(str);  
    }  
}
