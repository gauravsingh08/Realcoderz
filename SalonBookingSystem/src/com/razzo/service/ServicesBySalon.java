package com.razzo.service;

import java.sql.SQLException;

import com.razzo.entity.Services;

public interface ServicesBySalon {


//	int insertBooking(Booking booking) throws ClassNotFoundException, SQLException;

//	void updateBooking(Booking booking) throws ClassNotFoundException, SQLException;

	Services readService(String serviceName) throws ClassNotFoundException, SQLException;

	String readServiceName(int serviceId) throws ClassNotFoundException, SQLException;

	float readServicePrice(int serviceId) throws ClassNotFoundException, SQLException;

//	void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException;

}
