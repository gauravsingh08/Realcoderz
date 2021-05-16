package com.razzo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.razzo.servlet.LoginServlet;

public class DbUtility {
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	public static final String url = "jdbc:mysql://localhost:3306/salonbookingsystem";
	public static final String userName = "root";
	public static final String password = "root1998";
	public static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Class.forName("com.mysql.jdbc.driver");
		LOGGER.info("Driver Registered");
		connection = DriverManager.getConnection(url, userName, password);
		LOGGER.info("Connection Established");
		// to check JDBC version
		// DatabaseMetaData databaseMetaData = connection.getMetaData();
		// System.out.println("JDBC version" + databaseMetaData.getJDBCMajorVersion());
		return connection;
	}

	public static void getDbConnectionClose() throws SQLException {

		if (connection != null) {
			connection.close();
			LOGGER.info("Connection closed");
		}
	}

}
