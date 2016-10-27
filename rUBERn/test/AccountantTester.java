import static org.junit.Assert.*;

import org.junit.Test;
import logic.*;
public class AccountantTester {

	@Test
	public void imageCostTest() {
		ClientBase aBase= new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix aMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		User aClient = new User("pablo", 233223, "holaaa");
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		aDriver.updateLocation(3323, 2323);
		long[] aDestination = {45, 43};
		Trip aTrip = new Trip(aDriver, aClient, aDestination);
		Accountant anAccountant = new Accountant(aMatrix);
		assertEquals(81.089, anAccountant.imageCost(aTrip), 0.001);
	}
	@Test
	public void tripCostTest() {
		ClientBase aBase= new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix aMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		User aClient = new User("pablo", 233223, "holaaa");
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		aDriver.updateLocation(3323, 2323);
		long[] aDestination = {4500, 4300};
		Trip aTrip = new Trip(aDriver, aClient, aDestination);
		Accountant anAccountant = new Accountant(aMatrix);
		assertEquals(77.241, anAccountant.tripCost(aTrip), 0.001);
	}

}
