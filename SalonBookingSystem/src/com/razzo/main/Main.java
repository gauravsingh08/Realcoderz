package com.razzo.main;

import java.sql.SQLException;
import java.util.List;

import com.razzo.dao.BookingDAO;
import com.razzo.dao.BookingDAOImpl;
import com.razzo.entity.Booking;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*
		 * I created this to check the application logic. You can delete this.
		 */

		BookingDAO book = new BookingDAOImpl();
		List<Booking> list = book.readBooking(102);

		System.out.println(list + "/n");

		
		}

}