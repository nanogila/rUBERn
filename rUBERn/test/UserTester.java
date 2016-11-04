import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.NotEnoughMoneyException;
import logic.*;

public class UserTester {
	@Rule
	public ExpectedException exception = ExpectedException.none();
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
	public void testRemoveMoney() throws NotEnoughMoneyException {
		User Juan = new User("Juan", 2134, "sregth");
		Juan.addMoney(23.0);
		Juan.removeMoney(20.5);
		assertEquals(2.5, Juan.getBalance(), 0.0001);

	}
	@Test
	public void testRemoveMoneyFail() throws NotEnoughMoneyException{
		exception.expect(NotEnoughMoneyException.class);
		User Juan = new User("Juan", 2134, "sregth");
		Juan.addMoney(2.0);
		Juan.removeMoney(23.0);
	}
}
