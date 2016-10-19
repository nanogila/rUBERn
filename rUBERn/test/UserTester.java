import static org.junit.Assert.*;
import org.junit.Test;

import logic.*;

public class UserTester {
	@Test
	public void testGetName() {
		User Pablo = new User("Pablo", 2134);
		assertEquals("Pablo", Pablo.getName());
	}

	@Test
	public void testGetCard() {
		User Juan = new User("Juan", 2134);
		assertEquals((Integer)2134, Juan.getCard());

	}
	@Test
	public void testGetLocation() {
		User Juan = new User("Juan", 2134);
		Juan.updateLocation(123, 456);
		assertEquals("[123, 456]", Juan.getLocation());

	}
}
