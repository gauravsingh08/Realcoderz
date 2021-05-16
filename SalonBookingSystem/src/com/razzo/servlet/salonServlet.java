package com.razzo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.razzo.entity.Booking;
import com.razzo.entity.Customer;
import com.razzo.entity.Salon;
import com.razzo.entity.Services;
import com.razzo.service.BookingService;
import com.razzo.service.BookingServiceImpl;
import com.razzo.service.SalonService;
import com.razzo.service.SalonServiceImpl;
import com.razzo.service.ServicesBySalon;
import com.razzo.service.ServicesBySalonImpl;

//@WebServlet("/salonServlet")
public class salonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	SalonService salonService = new SalonServiceImpl();
	BookingService bookingService = new BookingServiceImpl();
	ServicesBySalon serviceBySalon = new ServicesBySalonImpl();

	Booking booking = new Booking();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// retrieve information about customer from session that we created
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");

		String salonName = request.getParameter("salonName");
		String serviceName = request.getParameter("serviceName");
		String bookingTime = request.getParameter("bookingTime");

		// delete// this will be null because new request is generated each time
		// Customer customer = (Customer) request.getAttribute("customer");

		// interacting with DB
		try {
			Salon salon = salonService.readSalon(salonName);
			Services service = serviceBySalon.readService(serviceName);

			// inserting in booking table
			booking.setUserId(customer.getUserId());
			booking.setSalonId(salon.getSalonId());
			booking.setServiceId(service.getServiceId());
			booking.setBookingTime(bookingTime);

			bookingService.insertBooking(booking);

			LOGGER.info("Booking successfully Created with details-> " + booking);

			out.println("<h1>Booking successfull</h1>");
			out.println("<a href='salon.html'>Back to Home Page</a>");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}
}
