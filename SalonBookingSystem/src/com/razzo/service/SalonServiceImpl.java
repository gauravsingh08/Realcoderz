package com.razzo.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.razzo.dao.SalonDAO;
import com.razzo.dao.SalonDAOImpl;
import com.razzo.entity.Salon;
import com.razzo.servlet.LoginServlet;

public class SalonServiceImpl implements SalonService {
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	private SalonDAO salonDAO = new SalonDAOImpl();

	@Override
	public int insertSalon(Salon salonBean) throws ClassNotFoundException, SQLException {
		int rowsUpdateCount = 0;

		try {

			rowsUpdateCount = salonDAO.insertSalon(salonBean);
			LOGGER.info("insertSalon successfull");

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());

		}

		return rowsUpdateCount;
	}

	/*
	 * @Override public void updateTodo(TodoBean todoBean) throws
	 * ClassNotFoundException, SQLException { try { todoDAO.updateTodo(todoBean); }
	 * catch (ClassNotFoundException | SQLException e) {
	 * System.out.println(e.getMessage()); } catch (Exception e) { throw e; } }
	 * 
	 * @Override public void readTodo() throws ClassNotFoundException, SQLException
	 * {
	 * 
	 * try { todoDAO.readTodo(); } catch (ClassNotFoundException | SQLException e) {
	 * System.out.println(e.getMessage()); } catch (Exception e) { throw e; } }
	 * 
	 * @Override public void deleteTodo(TodoBean todoBean) throws
	 * ClassNotFoundException, SQLException { try { todoDAO.deleteTodo(todoBean); }
	 * catch (ClassNotFoundException | SQLException e) {
	 * System.out.println(e.getMessage()); } catch (Exception e) { throw e; } }
	 */

	@Override
	public void updateSalon(Salon salonBean) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Salon readSalon(String salonName) throws ClassNotFoundException, SQLException {
		Salon salon = null;
		try {
			salon = salonDAO.readSalon(salonName);
			LOGGER.info("readSalon successfull");

			return salon;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return salon;

	}
		

	@Override
	public void deleteSalon(Salon salonBean) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String readSalonName(int salonId) throws ClassNotFoundException, SQLException {
		String name = "";
		try {

			name = salonDAO.readSalonName(salonId);
			LOGGER.info("readSalonName successfull");
			return name;

		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return name;
	}




}
