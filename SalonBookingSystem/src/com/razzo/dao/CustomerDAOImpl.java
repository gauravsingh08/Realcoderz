package com.razzo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.razzo.entity.Customer;
import com.razzo.servlet.LoginServlet;
import com.razzo.util.DbUtility;

public class CustomerDAOImpl implements CustomerDAO {

	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	private static Connection connection = null;
	private static Statement statement = null;

	@Override
	public int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		try {
			connection = DbUtility.getConnection();
			int rowUpdateCount = 0;

			String userName = customer.getUserName();
			String userEmail = customer.getUserEmail();
			String userPassword = customer.getUserPassword();
			String userAddress = customer.getUserAddress();
			long userPhoneNo = customer.getUserPhoneNo();
			char userGender = customer.getUserGender();

			String insertData = "insert into customer(userName,userEmail,userPassword,userAddress,userPhoneNo,userGender) values"
					+ "('" + userName + "','" + userEmail + "','" + userPassword + "','" + userAddress
					+ "','" + userPhoneNo + "','" + userGender + "')";

			statement = connection.createStatement();
			rowUpdateCount = statement.executeUpdate(insertData);

			if (rowUpdateCount > 0) {
				LOGGER.info("CUSTOMER Added successfully");
			} else {
				LOGGER.error("OOPS something went wrong");
			}

			return rowUpdateCount;

		} catch (Exception e) {
			throw e;
		} finally {
			DbUtility.getDbConnectionClose();
		}

	}


	@Override
	public void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer readCustomer(String userEmail, String userPassword) throws ClassNotFoundException, SQLException {

		String retriveData = "select * from customer where userEmail=  '" + userEmail + "' and userPassword='"
				+ userPassword + "'";


		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);
		Customer customer = new Customer();
		
			 
			while (resultSet.next()){

				customer.setUserId(Integer.parseInt(resultSet.getString("userId")));
				customer.setUserName(resultSet.getString("userName"));
				customer.setUserEmail(resultSet.getString("userEmail"));
				customer.setUserPassword(resultSet.getString("userpassword"));
				customer.setUserAddress(resultSet.getString("userAddress"));
				customer.setUserPhoneNo(Long.parseLong(resultSet.getString("userPhoneNo")));
				String Gender = resultSet.getString("userGender");
				customer.setUserGender(Gender.charAt(0));



	}

	return customer;
}

	@Override
	public int deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 1;
		
	}

}


