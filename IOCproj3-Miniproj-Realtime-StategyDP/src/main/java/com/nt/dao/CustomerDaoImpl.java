package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.nt.model.Customer;
@Repository("custDAO")
public class CustomerDaoImpl implements ICustomerDao {
   private static final String CUSTOMER_INFO_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER_INFO VALUES(CNO_SEQ1.NEXTVAL,?,?,?,?,?)";
    @Autowired
   public DataSource ds;
   
   @Override
	public int insert (Customer cust) throws Exception{
	   
	 int count=0;
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(CUSTOMER_INFO_INSERT_QUERY);) 
	{
		//SET QUERRY PARAM VALUE
		ps.setString(1, cust.getCname());
		ps.setString(2, cust.getCadd());
		ps.setDouble(3, cust.getBillamount());
		ps.setDouble(4, cust.getDiscount());
		ps.setDouble(5, cust.getFinalamount());
		
		//execute query
	    count=ps.executeUpdate();
		
	} catch (SQLException se) {
	     se.printStackTrace();
	     throw se;//exception rethrowing for exception propagation
	}
	catch (Exception e) {
		e.printStackTrace();
		throw e;//exception rethrowing for exception propagation
	}
		return count;
	}

}
