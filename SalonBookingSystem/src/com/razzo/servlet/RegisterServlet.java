package com.razzo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.razzo.entity.Customer;
import com.razzo.service.CustomerService;
import com.razzo.service.CustomerServiceImpl;

//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);


	CustomerService customerService = new CustomerServiceImpl();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userAddress = request.getParameter("userAddress");
		Long userPhoneNo = Long.parseLong(request.getParameter("userPhoneNo"));
		char userGender = request.getParameter("userGender").charAt(0);
		
		Customer customer = new Customer();

		customer.setUserName(userName);
		customer.setUserEmail(userEmail);
		customer.setUserPassword(userPassword);
		customer.setUserAddress(userAddress);
		customer.setUserPhoneNo((userPhoneNo));
		customer.setUserGender(userGender);

		try {
			customerService.insertCustomer(customer);
			response.sendRedirect("login.html");

			LOGGER.info("Acoount Created with Email ID- " + customer.getUserEmail());

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
