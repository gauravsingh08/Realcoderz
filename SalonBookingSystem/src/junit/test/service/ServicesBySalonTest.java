package junit.test.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.razzo.entity.Services;
import com.razzo.service.ServicesBySalon;
import com.razzo.service.ServicesBySalonImpl;

public class ServicesBySalonTest {

	private ServicesBySalon service;

	@Before
	public void setup() {
		service = new ServicesBySalonImpl();
	}

	@After
	public void tearDown() {
		service = null;
	}

	@Test
	public void readServiceTest() throws ClassNotFoundException, SQLException {
		Services services = new Services(302, "Beard", "Best Beard styling by our professional stylist", 100);

		assertEquals("failed to read service", services, service.readService("Beard"));
	}

	@Test
	public void readServiceNameTest() throws ClassNotFoundException, SQLException {

		assertEquals("failed to read service name", "Beard", service.readServiceName(302));

	}

	@Test
	public void readServicePriceTest() throws ClassNotFoundException, SQLException {

		assertEquals(100, service.readServicePrice(302), 0.0);

	}


}
