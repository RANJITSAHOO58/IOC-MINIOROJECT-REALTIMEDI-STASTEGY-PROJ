//CustomerOperationController.java
package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Customer;
import com.nt.service.ICustomerMngtService;

@Controller("custcontroller")
public class CustomerOperationsController {
	@Autowired
 private ICustomerMngtService custservice;
 public String processCustomer(Customer customer)throws Exception {
	 //use service class
	 String result=custservice.registerCustomer(customer);
	 return result;
 }
}
