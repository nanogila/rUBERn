import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class DriverTest {
	Car fiat = new Car("Fiat 600", 3, new QualityTag("low", 2));
	@Test
	public void carTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		
		assertEquals("Fiat 600", aDriver.getCarModel());
	}
	@Test
	public void locationTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.updateLocation(324, 432);
		assertEquals("[324, 432]", aDriver.getLocationToString());
	}
	@Test
	public void onlineTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);

		assertTrue(aDriver.goOnline());
	}
	@Test
	public void onlineFailTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.goOnline();
		assertTrue(!aDriver.goOnline());
	}
	@Test
	public void offlineTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		assertTrue(!aDriver.goOffline());
	}
	
	@Test
	public void offlineFailTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		
		assertTrue(!aDriver.goOffline());
	}
	@Test
	public void changeStatesStressTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		for(int i=0; i<100; i++) {
		aDriver.goOffline();
		aDriver.goOnline();
		}
		assertTrue(aDriver.goOffline());
	}
	@Test
	public void checkStatusTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.goOnline();
		assertTrue(aDriver.isAvailable());
	}
	@Test
	public void addMoneyTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.addMoney(20.0);
		assertEquals(20.0, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.addMoney(20.0);
		aDriver.removeMoney(5.5);
		assertEquals(14.5, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyFailTest() {
		Driver aDriver = new Driver("Mario", 123213, "password", fiat);
		aDriver.addMoney(20.0);
		aDriver.removeMoney(40.5);
		assertEquals(20.0, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void changedQualityTagValueTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		User aClient = new User("pablo", 233223, "holaaa");
		QualityTag high = new QualityTag("high", 2);
		Car Mercedes = new Car("Fiat 600", 3, high);
		Driver aDriver = new Driver("mario", 23423, "holass", Mercedes);
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		Matrix aMatrix=new Matrix(aBase, anotherBase);
		aMatrix.addDriver(aDriver);
		aMatrix.addUser(aClient);
		aMatrix.addTag(high);
		aMatrix.setTagValue("high", 8);
		aDriver.updateLocation(3323, 2323);
		long[] aDestination = {45, 43};
		Trip aTrip = new Trip(aDriver, aClient, aDestination);
		assertEquals(20.27, anAccountant.imageCost(aTrip), 0.01);
	}
	
}
