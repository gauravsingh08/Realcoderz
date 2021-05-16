package junit.test.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.razzo.entity.Booking;
import com.razzo.service.BookingService;
import com.razzo.service.BookingServiceImpl;

public class BookingServiceTest {

	private BookingService service;

	@Before
	public void setup() {
		service = new BookingServiceImpl();
	}

	@After
	public void tearDown() {
		service = null;
	}

	@Test
	@Ignore
	public void insertBookingTest() throws ClassNotFoundException, SQLException {
		Timestamp ts1 = Timestamp.valueOf("2021-09-01 09:01:15");
		assertEquals("failed to insert", 1, service.insertBooking(new Booking(107, 201, 302, ts1.toString())));
	}

	@Test
	public void readBookingTest() throws ClassNotFoundException, SQLException {

		List<Booking> list = new ArrayList<Booking>();
		assertEquals("failed to read", list, service.readBooking(200));

	}

	@Test
	@Ignore
	public void deleteBookingTest() throws ClassNotFoundException, SQLException {

		assertEquals("failed to delete", 1, service.deleteBooking(15));// As you add booking in insertBookingTest()
																		// Try giving that booking id only

	}

}
