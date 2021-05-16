package junit.test.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.razzo.dao.BookingDAO;
import com.razzo.dao.BookingDAOImpl;
import com.razzo.entity.Booking;

public class BookingDaoTest {

	private BookingDAO dao;

	@Before
	public void setup() {
		dao = new BookingDAOImpl();
	}

	@After
	public void tearDown() {
		dao = null;
	}

	@Test
	@Ignore
	public void insertBookingTest() throws ClassNotFoundException, SQLException {
		Timestamp ts1 = Timestamp.valueOf("2021-09-01 09:01:15");
		assertEquals("failed to insert", 1, dao.insertBooking(new Booking(107, 201, 302, ts1.toString())));
	}

	@Test
	public void readBookingTest() throws ClassNotFoundException, SQLException {

		List<Booking> list = new ArrayList<Booking>();
		assertEquals("failed to read", list, dao.readBooking(200));

	}

	@Test
	@Ignore
	public void deleteBookingTest() throws ClassNotFoundException, SQLException {

		assertEquals("failed to delete", 1, dao.deleteBooking(15));// As you add booking in insertBookingTest()
																	// Try giving that booking id only

	}

}
