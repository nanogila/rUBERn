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

}
