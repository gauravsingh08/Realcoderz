package com.razzo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.razzo.dao.BookingDAO;
import com.razzo.dao.BookingDAOImpl;
import com.razzo.entity.Booking;
import com.razzo.servlet.LoginServlet;

public class BookingServiceImpl implements BookingService {

	private BookingDAO bookingDAO = new BookingDAOImpl();
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	@Override
	public int insertBooking(Booking booking) throws ClassNotFoundException, SQLException {
		int rowsUpdateCount = 0;

		try {

			rowsUpdateCount = bookingDAO.insertBooking(booking);
			LOGGER.info("insertBooking successfull");
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());

		}

		return rowsUpdateCount;
	}



	@Override
	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	

	@Override
	public int deleteBooking(int bookingId) throws ClassNotFoundException, SQLException {

		int rowsUpdateCount = 0;

		try {

			rowsUpdateCount = bookingDAO.deleteBooking(bookingId);
			LOGGER.info("deleteBooking successfull");
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());

		}

		return rowsUpdateCount;
		
		
		
	}



	@Override
	public List<Booking> readBooking(int userId) throws ClassNotFoundException, SQLException {
		
		List<Booking> list = new ArrayList<Booking>();

		try {
			list = bookingDAO.readBooking(userId);
			LOGGER.info("readBooking unsuccessfull");
			return list;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}
}





