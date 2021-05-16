package com.razzo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.razzo.entity.Booking;
import com.razzo.servlet.LoginServlet;
import com.razzo.util.DbUtility;

public class BookingDAOImpl implements BookingDAO {
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);


	private static Connection connection = null;
	private static Statement statement = null;

	@Override
	public int insertBooking(Booking booking) throws ClassNotFoundException, SQLException {
		try {
			connection = DbUtility.getConnection();
			int rowUpdateCount = 0;


			int userId = booking.getUserId();
			int salonId = booking.getSalonId();
			int serviceId = booking.getServiceId();
			String bookingTime = booking.getBookingTime();

			String insertData = "insert into booking(userId,salonId,serviceId,bookingTime) values" + "('" + userId
					+ "','" + salonId + "','" + serviceId + "','" + bookingTime + "')";

			statement = connection.createStatement();
			rowUpdateCount = statement.executeUpdate(insertData);

			if (rowUpdateCount > 0) {

				LOGGER.info("Booking successfully");
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
	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Booking> readBooking(int userId) throws ClassNotFoundException, SQLException {
		// booking id||salon name||user name||service name||price||time

		List<Booking> list = new ArrayList<Booking>();


		String retriveData = "select * from booking where userId=  '" + userId + "' ";

		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);


		 while (resultSet.next()){
				Booking booking = new Booking();
			booking.setBookingId(Integer.parseInt(resultSet.getString("bookingId")));
			booking.setUserId(Integer.parseInt(resultSet.getString("userId")));
			booking.setSalonId(Integer.parseInt(resultSet.getString("salonId")));
			booking.setServiceId(Integer.parseInt(resultSet.getString("serviceId")));
			booking.setBookingTime(resultSet.getString("bookingTime"));

			list.add(booking);

		}

		return list;
		
	}

	@Override
	public int deleteBooking(int bookingId) throws ClassNotFoundException, SQLException {
		try {
			connection = DbUtility.getConnection();
			int rowUpdateCount = 0;

			String deleteData = "delete from booking where bookingId = '" + bookingId + "'";

			statement = connection.createStatement();
			rowUpdateCount = statement.executeUpdate(deleteData);

			if (rowUpdateCount > 0) {
				LOGGER.info("Booking deleted successfully");
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


}


