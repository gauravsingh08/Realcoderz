package com.razzo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.razzo.entity.Booking;
import com.razzo.entity.BookingDetails;
import com.razzo.entity.Customer;
import com.razzo.service.BookingService;
import com.razzo.service.BookingServiceImpl;
import com.razzo.service.SalonService;
import com.razzo.service.SalonServiceImpl;
import com.razzo.service.ServicesBySalon;
import com.razzo.service.ServicesBySalonImpl;


@WebServlet("/ShowBookingServlet")
public class ShowBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookingService bookingService = new BookingServiceImpl();
	ServicesBySalon service = new ServicesBySalonImpl();
	SalonService salonService = new SalonServiceImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//get customer info using session
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		int userId = customer.getUserId();
		//get list of booking of customer
		List<Booking> list = new ArrayList<Booking>();
		List<BookingDetails> bookingList = new ArrayList<BookingDetails>();
		try {
			list = bookingService.readBooking(userId);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		

		for(int i = 0; i<list.size();i++) {
			BookingDetails details= new BookingDetails();
			Booking booking = list.get(i);
			
			
			String serviceName = "";
			float price = 0f;
			String salonName = "";

			try {
				serviceName = service.readServiceName(booking.getServiceId());
				price = service.readServicePrice(booking.getServiceId());
				salonName = salonService.readSalonName(booking.getSalonId());
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			
			
		details.setBookingId(booking.getBookingId());//done
		details.setUserName(customer.getUserName());//done
		details.setSalonName(salonName);
		details.setServiceName(serviceName);
		details.setPrice(price);
		details.setTime(booking.getBookingTime());//done
		
		bookingList.add(details);


		}
		
		Gson gson = new Gson();

		JsonElement element = gson.toJsonTree(bookingList, new TypeToken<List<BookingDetails>>() {
		}.getType());
		JsonArray array = element.getAsJsonArray();

		response.setContentType("application/json");
		response.getWriter().print(array);
		
		
		

	}

}
