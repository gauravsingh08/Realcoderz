package com.razzo.dao;

import java.sql.SQLException;
import java.util.List;

import com.razzo.entity.Booking;


public interface BookingDAO {

	int insertBooking(Booking booking) throws ClassNotFoundException, SQLException;

	void updateBooking(Booking booking) throws ClassNotFoundException, SQLException;

	List<Booking> readBooking(int userId) throws ClassNotFoundException, SQLException;

	int deleteBooking(int bookingId) throws ClassNotFoundException, SQLException;
}
