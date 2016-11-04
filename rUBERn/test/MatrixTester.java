

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
import exceptions.NotEnoughMoneyException;
import logic.*;

public class MatrixTester {
	Robot bot;
	ClientBase aBase = new ClientBase();
	DriverBase anotherBase = new DriverBase();
	Car aCar = new Car("Fiat 600", 3, new QualityTag("low", 2));
	Driver aDriver = new Driver("Maria", 23423, "holass", aCar);
	User aUser = new User("Jose", 1231, "hola");
	Matrix theMatrix = new Matrix(aBase, anotherBase);
		Thread ok = new Thread () {
			  public void run () {
					try { bot = new Robot(); } catch (AWTException e) {e.printStackTrace();}
				  for (int i = 0; i<16; i++) {
					  try{Thread.sleep(100);}catch(InterruptedException e){}
				  bot.keyPress(KeyEvent.VK_ENTER);
					try{Thread.sleep(50);}catch(InterruptedException e){}
					bot.keyRelease(KeyEvent.VK_ENTER);
			  }
			  }
			};
			@Rule
			public ExpectedException exception = ExpectedException.none();
	@Test
	public void addMoneyTest() throws EmptyFieldException, ItemNotFoundException {
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 10);
		assertEquals(10, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyTest() throws ItemNotFoundException, NotEnoughMoneyException {
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 20);
		theMatrix.removeMoney(aDriver, 10);
		assertEquals(10, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyFailTest() throws ItemNotFoundException, NotEnoughMoneyException {
		exception.expect(NotEnoughMoneyException.class);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 20);
		theMatrix.removeMoney(aDriver, 30);
		assertEquals(20, aDriver.getBalance(), 0.01);
	}
	@Test
	public void getUserTest() throws ItemNotFoundException {
		theMatrix.addUser(aUser);
		User anotherUser = theMatrix.getUser(aUser.getName());
		assertEquals(aUser, anotherUser);
	}
	@Test
	public void checkPasswordTest() {
		theMatrix.addUser(aUser);
		assertTrue(theMatrix.checkPassword(aUser.getName(), "hola"));
	}
	@Test
	public void checkPasswordFailTest() {
		theMatrix.addUser(aUser);
		assertTrue(!theMatrix.checkPassword(aUser.getName(), "holal"));
	}
	@Test
	public void checkDriverPasswordFailTest() {
		theMatrix.addDriver(aDriver);
		assertTrue(!theMatrix.checkPassword(aDriver.getName(), "hola"));
	}
	@Test
	public void checkDriverPasswordTest() {
		theMatrix.addDriver(aDriver);
		assertTrue(theMatrix.checkDriverPassword(aDriver.getName(), "holass"));
	}
	@Test
	public void  checkAskForCarTest() throws NotEnoughMoneyException, ItemNotFoundException {
		theMatrix.addUser(aUser);
		theMatrix.addMoney(aUser, 234);
		theMatrix.addDriver(aDriver);
		aDriver.goOnline();
		long[] aDestination = {23, 3};
		ok.start();
		boolean result = theMatrix.askForCar(aUser, aDestination, 2);
		assertTrue(result);
	}
	@Test
	public void  checkChangeMaximumDistance() throws ItemNotFoundException, NotEnoughMoneyException {
		theMatrix.addUser(aUser);
		theMatrix.addMoney(aUser, 23444);
		theMatrix.addDriver(aDriver);
		aDriver.goOnline();
		long[] aDestination = {23, 3};
		ok.start();
		boolean result = theMatrix.askForCar(aUser, aDestination, 2);
		assertTrue(result);
		theMatrix.updateDriverLocation(5000, 32222, "Maria");
		theMatrix.changeMaximumDriverDistance(3);
		boolean newResult = theMatrix.askForCar(aUser, aDestination, 2);
		assertTrue(!newResult);
	}
}
