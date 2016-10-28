import static org.junit.Assert.*;
import org.junit.Test;

import logic.*;

public class UserTester {
	@Test
	public void testGetName() {
		User Pablo = new User("Pablo", 2134, "gola");
		assertEquals("Pablo", Pablo.getName());
	}

	@Test
	public void testGetCard() {
		User Juan = new User("Juan", 2134, "gol");
		assertEquals((Integer)2134, Juan.getCardNumber());

	}
	@Test
	public void testGetLocation() {
		User Juan = new User("Juan", 2134, "sregth");
		Juan.updateLocation(123, 456);
		assertEquals("[123, 456]", Juan.getLocationToString());

	}
	@Test
	public void testAddMoney() {
		User Juan = new User("Juan", 2134, "sregth");
		Juan.addMoney(23.0);
		assertEquals(23.0, Juan.getBalance(), 0.0001);

	}
	@Test
	public void testRemoveMoney() {
		User Juan = new User("Juan", 2134, "sregth");
		Juan.addMoney(23.0);
		Juan.removeMoney(20.5);
		assertEquals(2.5, Juan.getBalance(), 0.0001);

	}
	@Test
	public void testRemoveMoneyFail() {
		User Juan = new User("Juan", 2134, "sregth");
		Juan.addMoney(2.0);
		Juan.removeMoney(23.0);
		assertEquals(2.0, Juan.getBalance(), 0.0001);

	}
}
