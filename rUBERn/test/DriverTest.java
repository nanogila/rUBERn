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
	@Test
	public void addMoneyTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.addMoney(20.0);
		assertEquals(20.0, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.addMoney(20.0);
		aDriver.removeMoney(5.5);
		assertEquals(14.5, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyFailTest() {
		Car fiat = new Fiat600();
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.addMoney(20.0);
		aDriver.removeMoney(40.5);
		assertEquals(20.0, aDriver.getBalance(), 0.00001);
	}
}
