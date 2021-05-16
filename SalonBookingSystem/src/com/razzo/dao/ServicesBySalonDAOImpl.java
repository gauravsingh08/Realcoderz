package com.razzo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.razzo.entity.Services;
import com.razzo.util.DbUtility;

public class ServicesBySalonDAOImpl implements ServicesBySalonDAO {

	private static Connection connection = null;
	private static Statement statement = null;
	@Override
	public Services readService(String serviceName) throws ClassNotFoundException, SQLException {

		String retriveData = "select * from services where serviceName=  '" + serviceName + "'";

		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);
		Services service = new Services();
		while (resultSet.next()) {

			service.setServiceId(Integer.parseInt(resultSet.getString("serviceId")));
			service.setServiceName(resultSet.getString("serviceName"));
			service.setServiceDescription(resultSet.getString("serviceDescription"));
			service.setServicePrice(Float.parseFloat(resultSet.getString("servicePrice")));
		
	}

	return service;

	}

	@Override
	public String readServiceName(int serviceId) throws ClassNotFoundException, SQLException {
		String retriveData = "select serviceName  from services where serviceId=  '" + serviceId + "'";

		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);
		String name = "";
		while (resultSet.next()) {
			name = resultSet.getString("serviceName");
		}
		return name;
	}

	@Override
	public float readServicePrice(int serviceId) throws ClassNotFoundException, SQLException {
		String retriveData = "select servicePrice from services where serviceId=  '" + serviceId + "'";

		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);
		Float price = 0f;
		while (resultSet.next()) {
			price = Float.parseFloat(resultSet.getString("servicePrice"));
		}
		return price;
				}
}


