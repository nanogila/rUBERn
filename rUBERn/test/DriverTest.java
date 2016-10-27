import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class DriverTest {

	@Test
	public void carTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		
		assertEquals("Fiat 600", aDriver.getCarModel());
	}
	@Test
	public void locationTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.updateLocation(324, 432);
		assertEquals("[324, 432]", aDriver.getLocationToString());
	}
	@Test
	public void onlineTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);

		assertTrue(aDriver.goOnline());
	}
	@Test
	public void onlineFailTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.goOnline();
		assertTrue(!aDriver.goOnline());
	}
	@Test
	public void offlineTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		assertTrue(!aDriver.goOffline());
	}
	
	@Test
	public void offlineFailTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		
		assertTrue(!aDriver.goOffline());
	}
	@Test
	public void changeStatesStressTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		for(int i=0; i<100; i++) {
		aDriver.goOffline();
		aDriver.goOnline();
		}
		assertTrue(aDriver.goOffline());
	}
	@Test
	public void checkStatusTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.goOnline();
		assertTrue(aDriver.isAvailable());
	}
}
