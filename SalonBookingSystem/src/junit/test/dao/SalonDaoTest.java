package junit.test.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.razzo.dao.SalonDAO;
import com.razzo.dao.SalonDAOImpl;
import com.razzo.entity.Salon;

public class SalonDaoTest {

	private SalonDAO dao;

	@Before
	public void setup() {
		dao = new SalonDAOImpl();
	}

	@After
	public void tearDown() {
		dao = null;
	}

	@Test
	@Ignore
	public void insertSalonTest() throws ClassNotFoundException, SQLException {
		assertEquals("failed to insert", 1, dao.insertSalon(new Salon("dummy data salon", "dummy address", 5.0f)));
	}

	@Test
	public void readSalonTest() throws ClassNotFoundException, SQLException {

		Salon salon = new Salon("dummy data salon", "dummy address", 5.0f);
		assertEquals("failed to read", salon, dao.readSalon("dummy data salon"));

	}

	@Test
	public void readSalonNameTest() throws ClassNotFoundException, SQLException {

		assertEquals("failed to read", "dummy data salon", dao.readSalonName(0));

	}


}
