package com.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ioc.dao.PersonInterface;
import com.ioc.service.PersonServiceInterface;
import com.ioc.util.ClassPathXmlLoader;

public class PersonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		instanceSpring2();
	}
	
	public static void instanceSpring1(){  
        /** 
         *  
         * spring 的实现 
         */  
        //IOC  
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");  
        PersonInterface pd = (PersonInterface) ac.getBean("personDAO");  
        pd.save();  
        //DI  
        PersonServiceInterface ps = (PersonServiceInterface) ac.getBean("personService");  
        ps.save();  
    }  
	
	 public static void instanceSpring2(){  
         
	        /** 
	         * 我的实现 
	         *  
	         */  
	        ClassPathXmlLoader mac = new ClassPathXmlLoader("beans.xml");  
	        PersonInterface mpd = (PersonInterface) mac.getBean("personDAO");  
	        mpd.save();  
	        //DI  
	        PersonServiceInterface ps = (PersonServiceInterface) mac.getBean("personService");  
	        ps.save();  
	    }  
	      

}
