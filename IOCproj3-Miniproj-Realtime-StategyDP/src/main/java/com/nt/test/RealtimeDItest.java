//RealtimeDItest.java
package com.nt.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.CustomerOperationsController;
import com.nt.model.Customer;

public class RealtimeDItest {

	public static void main(String[] args) {
		//create scanner class object
		Scanner scn =new Scanner(System.in);
		//read input value from end user
		System.out.println("enter customer name::");
		String cname=scn.next();
		System.out.println("enter customer address::");
		String adds=scn.next();
		System.out.println("enter customer bill amount::");
		double billamount=scn.nextDouble();
		System.out.println("enter discount::");
		double discount=scn.nextDouble();
		
		//create customer class object
		Customer cust=new Customer();
		cust.setCname(cname);
		cust.setCadd(adds);
		cust.setBillamount(billamount);
		cust.setDiscount(discount);
		
		//create ioc container
		ClassPathXmlApplicationContext ctx=
				 new ClassPathXmlApplicationContext("com/nt/config/ApplicationContext.xml");
		
		//get controller cass object from ioc controller(dependancy lookup)
		CustomerOperationsController custcontrol=
				  ctx.getBean("custcontroller",CustomerOperationsController.class);

		//invoke the b method
		try {
			String resultmsg=custcontrol.processCustomer(cust);
			System.out.println(resultmsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}

}
