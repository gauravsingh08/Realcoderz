package com.razzo.service;

import java.sql.SQLException;

import com.razzo.entity.Salon;

public interface SalonService {

	int insertSalon(Salon salonBean) throws ClassNotFoundException, SQLException;

	void updateSalon(Salon salonBean) throws ClassNotFoundException, SQLException;

	Salon readSalon(String salonName) throws ClassNotFoundException, SQLException;

	void deleteSalon(Salon salonBean) throws ClassNotFoundException, SQLException;

	String readSalonName(int salonId) throws ClassNotFoundException, SQLException;


}
