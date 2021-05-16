package junit.test.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BookingServiceTest.class, CustomerServiceTest.class, SalonServiceTest.class,
		ServicesBySalonTest.class })
public class AllTestsServiceSuite {

}
