package com.razzo.dao;

import java.sql.SQLException;

import com.razzo.entity.Customer;


public interface CustomerDAO {

	int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException;

	void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException;

	Customer readCustomer(String userEmail, String userPassword) throws ClassNotFoundException, SQLException;

	int deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException;
}
