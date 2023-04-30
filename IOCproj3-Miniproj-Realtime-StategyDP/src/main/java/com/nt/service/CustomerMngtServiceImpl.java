//CustomerMngtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDao;
import com.nt.model.Customer;
@Service("custservice")
public class CustomerMngtServiceImpl implements ICustomerMngtService {
   @Autowired
   private ICustomerDao custdao;
	@Override
	public String registerCustomer(Customer customer) throws Exception {
		//calculate discount amount and final amount
		double discountamount=(customer.getBillamount()*(customer.getDiscount()/100.0));
		double finalamount=customer.getBillamount()-discountamount;
		//set finaal amount to dao class object
		customer.setFinalamount(finalamount);
		//useDao
		int count=custdao.insert(customer);
		
		
		return count==0?"customer registration failed":"customer registration having bill amount ::"+customer.getBillamount()+"discount amount ::"+discountamount+"final amount::"+finalamount;
	}

}
