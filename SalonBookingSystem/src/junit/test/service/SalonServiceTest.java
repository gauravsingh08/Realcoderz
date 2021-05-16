package junit.test.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.razzo.entity.Salon;
import com.razzo.service.SalonService;
import com.razzo.service.SalonServiceImpl;

public class SalonServiceTest {

	private SalonService service;

	@Before
	public void setup() {
		service = new SalonServiceImpl();
	}

	@After
	public void tearDown() {
		service = null;
	}

	@Test
	@Ignore
	public void insertSalonTest() throws ClassNotFoundException, SQLException {
		assertEquals("failed to insert", 1, service.insertSalon(new Salon("dummy data salon", "dummy address", 5.0f)));
	}

	@Test
	public void readSalonTest() throws ClassNotFoundException, SQLException {

		Salon salon = new Salon("dummy data salon", "dummy address", 5.0f);
		assertEquals("failed to read", salon, service.readSalon("dummy data salon"));

	}

	@Test
	public void readSalonNameTest() throws ClassNotFoundException, SQLException {

		assertEquals("failed to read", "dummy data salon", service.readSalonName(0));

	}


}
