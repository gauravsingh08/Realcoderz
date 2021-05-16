package junit.test.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.razzo.dao.ServicesBySalonDAO;
import com.razzo.dao.ServicesBySalonDAOImpl;
import com.razzo.entity.Services;

public class ServicesBySalonDaoTest {

	private ServicesBySalonDAO dao;

	@Before
	public void setup() {
		dao = new ServicesBySalonDAOImpl();
	}

	@After
	public void tearDown() {
		dao = null;
	}

	@Test
	public void readServiceTest() throws ClassNotFoundException, SQLException {
		Services service = new Services(302, "Beard", "Best Beard styling by our professional stylist", 100);

		assertEquals("failed to read service", service, dao.readService("Beard"));
	}

	@Test
	public void readServiceNameTest() throws ClassNotFoundException, SQLException {

		assertEquals("failed to read service name", "Beard", dao.readServiceName(302));

	}

	@Test
	public void readServicePriceTest() throws ClassNotFoundException, SQLException {

		assertEquals(100, dao.readServicePrice(302), 0.0);

	}


}
