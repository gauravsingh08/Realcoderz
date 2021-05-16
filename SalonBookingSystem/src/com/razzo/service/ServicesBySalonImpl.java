package com.razzo.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.razzo.dao.ServicesBySalonDAO;
import com.razzo.dao.ServicesBySalonDAOImpl;
import com.razzo.entity.Services;
import com.razzo.servlet.LoginServlet;

public class ServicesBySalonImpl implements ServicesBySalon {
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	ServicesBySalonDAO serviceBySalon = new ServicesBySalonDAOImpl();

	@Override
	public Services readService(String serviceName) throws ClassNotFoundException, SQLException {
		Services service = null;
		try {
			service = serviceBySalon.readService(serviceName);
			LOGGER.info("readService successfull");

			return service;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return service;
	}

	@Override
	public String readServiceName(int serviceId) throws ClassNotFoundException, SQLException {
		String name = "";
		try {
			name = serviceBySalon.readServiceName(serviceId);
			LOGGER.info("readServiceName successfull");

			return name;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return name;
	}

	@Override
	public float readServicePrice(int serviceId) throws ClassNotFoundException, SQLException {
		float price = 0;
		try {
			price = serviceBySalon.readServicePrice(serviceId);
			LOGGER.info("readServicePrice successfull");

			return price;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return price;
	}

}