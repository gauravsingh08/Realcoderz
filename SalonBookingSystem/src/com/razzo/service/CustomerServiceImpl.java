package com.razzo.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.razzo.dao.CustomerDAO;
import com.razzo.dao.CustomerDAOImpl;
import com.razzo.entity.Customer;
import com.razzo.servlet.LoginServlet;

public class CustomerServiceImpl implements CustomerService {
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	private CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		int rowsUpdateCount = 0;

		try {

			rowsUpdateCount = customerDAO.insertCustomer(customer);
			LOGGER.info("insertCustomer successfull");

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}

		return rowsUpdateCount;
	}


	@Override
	public void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer readCustomer(String userEmail, String userPassword) throws ClassNotFoundException, SQLException {
		Customer customer = null;
		try {
			customer = customerDAO.readCustomer(userEmail, userPassword);
			LOGGER.info("readCustomer successful");
			return customer;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return customer;

	}

	@Override
	public void deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}




}
