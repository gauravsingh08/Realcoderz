package com.razzo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.razzo.entity.Salon;
import com.razzo.servlet.LoginServlet;
import com.razzo.util.DbUtility;

public class SalonDAOImpl implements SalonDAO {

	private static Connection connection = null;
	private static Statement statement = null;
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	@Override
	public int insertSalon(Salon salonBean) throws ClassNotFoundException, SQLException {
		try {
			connection = DbUtility.getConnection();
			int rowUpdateCount = 0;

			int salonId = salonBean.getSalonId();
			String salonName = salonBean.getSalonName();
			String salonAddress = salonBean.getSalonAddress();
			float salonRating = salonBean.getSalonRating();

			String insertData = "insert into salon values" + "('" + salonId + "','" + salonName + "','" + salonAddress
					+ "','" + salonRating + "')";

			statement = connection.createStatement();
			rowUpdateCount = statement.executeUpdate(insertData);

			if (rowUpdateCount > 0) {
				LOGGER.info("Salon Added successfully");
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
	public void updateSalon() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}
	@Override
	public Salon readSalon(String salonName) throws ClassNotFoundException, SQLException {

		String retriveData = "select * from salon where salonName=  '" + salonName + "'";

		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);
		Salon salon = new Salon();

		while (resultSet.next()) {

			salon.setSalonId(Integer.parseInt(resultSet.getString("salonId")));
			salon.setSalonName(resultSet.getString("salonName"));
			salon.setSalonAddress(resultSet.getString("salonAddress"));
			salon.setSalonRating(Float.parseFloat(resultSet.getString("salonRating")));

		}

		return salon;
		
	}
	@Override
	public void deleteSalon(Salon salon) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String readSalonName(int salonId) throws ClassNotFoundException, SQLException {
		String retriveData = "select salonName  from salon where salonId=  '" + salonId + "'";

		connection = DbUtility.getConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(retriveData);
		String name = "";
		while (resultSet.next()) {
			name = resultSet.getString("salonName");
		}
		return name;
	}
}


