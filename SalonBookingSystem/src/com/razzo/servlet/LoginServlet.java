package com.razzo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.razzo.entity.Customer;
import com.razzo.service.CustomerService;
import com.razzo.service.CustomerServiceImpl;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	CustomerService customerService = new CustomerServiceImpl();

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Layout layout = new HTMLLayout();
//		Appender app = new ConsoleAppender(layout);
//		LOGGER.addAppender(app);
//
//		LOGGER.info("This is a logging statement from log4j");
//		System.out.print("-----------------------------------------------------------");
//		LOGGER.debug("from debug");
//
//		String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
//		response.getWriter().println(html);
//
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String register = request.getParameter("action");

		// getting session object created by container
		HttpSession session = request.getSession();
		// retrieving and printing session id
		LOGGER.info("session is created with session ID - " + session.getId());


		if (register != null && register.equals("Register")) {
			RequestDispatcher req = request.getRequestDispatcher("registration.html");
			req.forward(request, response);


		}
		else {
		Customer customer = null;

		try {
			customer = customerService.readCustomer(email, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		if (customer.getUserId() !=0 && customer.getUserEmail().equals(email) && customer.getUserPassword().equals(password)) {
			LOGGER.info("login sucessfully");

			// Storing information to session object(1st param->string and 2nd param->
			// object)
			session.setAttribute("customer", customer);

			// delete// while clicking on this hyperlink make a new request for session
			// object
			// but client is sending request in same session

			RequestDispatcher dispatcher = request.getRequestDispatcher("salon.html");

			request.setAttribute("customer", customer);
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher req = request.getRequestDispatcher("registration.html");
			req.forward(request, response);
		}

	} // End of else

	}

}
