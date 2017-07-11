package com.DAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Front {
	public static void main(String args[]){
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");

	      CSVRead	 obj = (CSVRead) context.getBean("CSVRead");

	      obj.test();
	}

}
