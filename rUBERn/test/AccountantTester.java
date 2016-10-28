import static org.junit.Assert.*;

import org.junit.Test;
import logic.*;
public class AccountantTester {

	@Test
	public void imageCostTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		User aClient = new User("pablo", 233223, "holaaa");
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		aDriver.updateLocation(3323, 2323);
		long[] aDestination = {45, 43};
		Trip aTrip = new Trip(aDriver, aClient, aDestination);
		assertEquals(81.09, anAccountant.imageCost(aTrip), 0.01);
	}
	@Test
	public void tripCostTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		User aClient = new User("pablo", 233223, "holaaa");
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		aDriver.updateLocation(3323, 2323);
		long[] aDestination = {4500, 4300};
		Trip aTrip = new Trip(aDriver, aClient, aDestination);
		assertEquals(77.24, anAccountant.tripCost(aTrip), 0.001);
	}
	@Test
	public void addMoneyTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		User aClient = new User("pablo", 233223, "holaaa");
		aBase.addUser(aClient);
		anAccountant.addMoney(aClient, 77);
		assertEquals(77, aClient.getBalance(), 0.001);
	}
	@Test
	public void addMoneyToDriverTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		anotherBase.addDriver(aDriver);
		anAccountant.addMoney(aDriver, 77);
		assertEquals(77, aDriver.getBalance(), 0.001);
	}
	@Test
	public void removeMoneyFromDriverTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		anotherBase.addDriver(aDriver);
		anAccountant.addMoney(aDriver, 77);
		anAccountant.removeMoney(aDriver, 10);
		assertEquals(67, aDriver.getBalance(), 0.001);
	}
	@Test
	public void removeMoneyTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Accountant anAccountant = new Accountant(aBase, anotherBase);
		User aClient = new User("pablo", 233223, "holaaa");
		aBase.addUser(aClient);
		anAccountant.addMoney(aClient, 77);
		anAccountant.removeMoney(aClient, 10, " testing the method");
		assertEquals(67, aClient.getBalance(), 0.001);
	}
}