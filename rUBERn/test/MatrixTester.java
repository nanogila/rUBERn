import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.*;

import org.junit.Test;


import logic.*;

public class MatrixTester {
	Robot bot;
	ClientBase aBase = new ClientBase();
	DriverBase anotherBase = new DriverBase();
	Car aCar = new Car("Fiat 600", 3, new QualityTag("low", 2));
	Driver aDriver = new Driver("Maria", 23423, "holass", aCar);
	User aUser = new User("Jose", 1231, "hola");
		Thread ok = new Thread () {
			  public void run () {
					try { bot = new Robot(); } catch (AWTException e) {}
				  try{Thread.sleep(50);}catch(InterruptedException e){}
				  bot.keyPress(KeyEvent.VK_ENTER);
					try{Thread.sleep(50);}catch(InterruptedException e){}
					bot.keyRelease(KeyEvent.VK_ENTER);
					  try{Thread.sleep(50);}catch(InterruptedException e){}
					  bot.keyPress(KeyEvent.VK_ENTER);
						try{Thread.sleep(50);}catch(InterruptedException e){}
						bot.keyRelease(KeyEvent.VK_ENTER);
						
			  }
			};
	@Test
	public void addMoneyTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 10);
		assertEquals(10, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 20);
		theMatrix.removeMoney(aDriver, 10);
		assertEquals(10, aDriver.getBalance(), 0.00001);
	}
	@Test
	public void removeMoneyFailTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addDriver(aDriver);
		theMatrix.addMoney(aDriver, 20);
		theMatrix.removeMoney(aDriver, 30);
		assertEquals(20, aDriver.getBalance(), 0.01);
	}
	@Test
	public void getUserTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		
		theMatrix.addUser(aUser);
		User anotherUser = theMatrix.getUser(aUser.getName());
		assertEquals(aUser, anotherUser);
	}
	@Test
	public void checkPasswordTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addUser(aUser);
		assertTrue(theMatrix.checkPassword(aUser.getName(), "hola"));
	}
	@Test
	public void checkPasswordFailTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addUser(aUser);
		assertTrue(!theMatrix.checkPassword(aUser.getName(), "holal"));
	}
	@Test
	public void checkDriverPasswordFailTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addDriver(aDriver);
		assertTrue(!theMatrix.checkPassword(aDriver.getName(), "hola"));
	}
	@Test
	public void checkDriverPasswordTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
		theMatrix.addDriver(aDriver);
		assertTrue(theMatrix.checkDriverPassword(aDriver.getName(), "holass"));
	}
	@Test
	public void  checkAskForCarTest() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
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
	public void  checkChangeMaximumDistance() {
		Matrix theMatrix = new Matrix(aBase, anotherBase);
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
		//ok2.start();
		boolean newResult = theMatrix.askForCar(aUser, aDestination, 2);
		assertTrue(!newResult);
	}
}
