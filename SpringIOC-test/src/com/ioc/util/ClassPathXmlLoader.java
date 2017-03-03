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
	 // xml���е�����  
    private ArrayList<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();  
    // xml�����е�bean  
    private Map<String, Object> sigletons = new HashMap<String, Object>();  
    
  
    public ClassPathXmlLoader(String file) {
    	super();
//  1 	��ȡbeans.xml�е��������ݵ�������
		readXml(file);  
//	2 	��ʼ�����е�bean��	
        instanceBeans(); 
//  3  	�������ɵ�����bean����������  
        instanceObject();
	}



	/** 
     * ע�� 
     */  
    private void instanceObject() {  
        for (BeanDefinition beanDefinition : beanDefinitions) {  
            //�ж���û��ע������  
            if (beanDefinition.getProperty() != null) {  
                Object bean = sigletons.get(beanDefinition.getId());  
                if (bean != null) {  
                    try {  
                        //�õ���ע��bean�����е�����  
                        PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();  
                        //�õ����е�ע��bean����  
                        for(PropertyDefinition propertyDefinition:beanDefinition.getProperty()){  
                            for(PropertyDescriptor propertyDescriptor:ps){  
                                if(propertyDescriptor.getName().equals(propertyDefinition.getName())){  
                                    Method setter = propertyDescriptor.getWriteMethod();//��ȡset����  
                                    if(setter!=null){  
                                        setter.setAccessible(true);//�õ�privateȨ��  
                                        //ע���Ѿ���ʼ���������  
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
     * ʵ�����е�bean 
     */  
    private void instanceBeans() {  
        for (int i = 0; i < beanDefinitions.size(); i++) {  
            BeanDefinition bd = beanDefinitions.get(i);  
            try {  
                try {  
                    if (bd.getClassName() != null  
                            && !bd.getClassName().equals(""))  
//                    	��beanDefinitions�е�bean ȫ����ʼ���������ֵ���
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
     * ��xml 
     *  
     * @param file 
     */  
    private void readXml(String file) {  
        try {  
//        	 ʹ��SAX��ʽ����XML
            SAXReader reader = new SAXReader();   
//            ��ȡ�����ļ�·��
            URL xmlPath = this.getClass().getClassLoader().getResource(file);  
            Document doc = reader.read(xmlPath);  
//          ȡ�ø��ڵ�  
            Element root = doc.getRootElement(); 
//            ��ȡ���и��ڵ��µ��ӽڵ�
            List<Element> beans = root.elements();
//            ���������ӽڵ�
            for (Element element : beans) {  
                String id = element.attributeValue("id");// id;  
                String clazz = element.attributeValue("class");  
                BeanDefinition bd = new BeanDefinition(id, clazz);  
                // ��ȡ�ӽڵ��е�������
                if (element.hasContent()) {  
                    List<Element> propertys = element.elements();  
                    for (Element property : propertys) {  
                        String name = property.attributeValue("name");  
                        String ref = property.attributeValue("ref");  
                        PropertyDefinition pd = new PropertyDefinition(name,  
                                ref);  
//                        ���������Ե�����
                        bd.getProperty().add(pd);  
                    }  
                } 
//                ���ӽڵ���ӵ�bean������
                beanDefinitions.add(bd);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
        }  
    }  
  
    /** 
     * ͨ�����ֵõ�bean 
     *  
     * @param str 
     * @return 
     */  
    public Object getBean(String str) {  
        return sigletons.get(str);  
    }  
}
