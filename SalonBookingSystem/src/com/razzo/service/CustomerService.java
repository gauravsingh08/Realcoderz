package com.razzo.service;

import java.sql.SQLException;

import com.razzo.entity.Customer;

public interface CustomerService {

	int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException;

	void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException;

	Customer readCustomer(String userEmail, String userPassword) throws ClassNotFoundException, SQLException;

	void deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException;

}
