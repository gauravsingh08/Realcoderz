package com.razzo.dao;

import java.sql.SQLException;

import com.razzo.entity.Salon;


public interface SalonDAO {

	int insertSalon(Salon salon) throws ClassNotFoundException, SQLException;

	void updateSalon() throws ClassNotFoundException, SQLException;

	Salon readSalon(String salonName) throws ClassNotFoundException, SQLException;

	void deleteSalon(Salon salon) throws ClassNotFoundException, SQLException;

	String readSalonName(int salonId) throws ClassNotFoundException, SQLException;
}
