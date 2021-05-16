package junit.test.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.razzo.dao.CustomerDAO;
import com.razzo.dao.CustomerDAOImpl;
import com.razzo.entity.Customer;

public class CustomerDaoTest {

	private CustomerDAO dao;

	@Before
	public void setup() {
		dao = new CustomerDAOImpl();
		System.out.println("before");
	}

	@After
	public void tearDown() {
		dao = null;
		System.out.println("after");
	}

	@Test
	@Ignore
	public void insertCustomerTest() throws ClassNotFoundException, SQLException {
		Customer customer = new Customer("test data", "test@123", "123", "dummy data", 78965421, 'M');
		assertEquals("Failed to insert customer", 1, dao.insertCustomer(customer));

	}

	@Test
	public void readBookingTest() throws ClassNotFoundException, SQLException {
		Customer customer = new Customer(112, "test data", "test@123", "123", "dummy data", 78965421, 'M');

		assertEquals("Failed to read customer", customer, dao.readCustomer("test@123", "123"));

	}

}
