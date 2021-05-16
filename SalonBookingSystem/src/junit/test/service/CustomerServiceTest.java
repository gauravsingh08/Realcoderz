package junit.test.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.razzo.entity.Customer;
import com.razzo.service.CustomerService;
import com.razzo.service.CustomerServiceImpl;

public class CustomerServiceTest {

	private CustomerService service;

	@Before
	public void setup() {
		service = new CustomerServiceImpl();
		System.out.println("before");
	}

	@After
	public void tearDown() {
		service = null;
		System.out.println("after");
	}

	@Test
	@Ignore
	public void insertCustomerTest() throws ClassNotFoundException, SQLException {
		Customer customer = new Customer("test data", "test@123", "123", "dummy data", 78965421, 'M');
		assertEquals("Failed to insert customer", 1, service.insertCustomer(customer));

	}

	@Test
	public void readBookingTest() throws ClassNotFoundException, SQLException {
		Customer customer = new Customer(112, "test data", "test@123", "123", "dummy data", 78965421, 'M');

		assertEquals("Failed to read customer", customer, service.readCustomer("test@123", "123"));

	}

}
