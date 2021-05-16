package junit.test.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BookingDaoTest.class, CustomerDaoTest.class, SalonDaoTest.class, ServicesBySalonDaoTest.class })
public class AllTestsDaoSuite {

}
