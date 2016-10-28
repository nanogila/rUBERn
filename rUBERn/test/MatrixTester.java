import static org.junit.Assert.*;

import org.junit.Test;

import logic.*;

public class MatrixTester {

	@Test
	public void addMoneyTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 10);
		assertEquals(10, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 20);
		theMatrix.removeMoney(aDriver, 10);
		assertEquals(10, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyFailTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 20);
		theMatrix.removeMoney(aDriver, 30);
		assertEquals(20, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void getUserTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		User aUser = new User("Mario", 1231, "hola");
		theMatrix.addUser(aUser);
		User anotherUser = theMatrix.getUser(aUser.getName());
		assertEquals(aUser, anotherUser);
	}
	@Test
	public void checkPasswordTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		User aUser = new User("Mario", 1231, "hola");
		theMatrix.addUser(aUser);
		assertTrue(theMatrix.checkPassword(aUser.getName(), "hola"));
	}
	@Test
	public void checkPasswordFailTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		User aUser = new User("Mario", 1231, "holaaaaaa");
		theMatrix.addUser(aUser);
		assertTrue(!theMatrix.checkPassword(aUser.getName(), "hola"));
	}
	@Test
	public void checkDriverPasswordFailTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		theMatrix.addDriver(aDriver);
		assertTrue(!theMatrix.checkPassword(aDriver.getName(), "hola"));
	}
	@Test
	public void checkDriverPasswordTest() {
		ClientBase aBase = new ClientBase();
		DriverBase anotherBase = new DriverBase();
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		Fiat600 aCar = new Fiat600();
		Driver aDriver = new Driver("mario", 23423, "holass", aCar);
		theMatrix.addDriver(aDriver);
		assertTrue(theMatrix.checkDriverPassword(aDriver.getName(), "holass"));
	}
}
