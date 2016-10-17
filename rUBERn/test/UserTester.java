import static org.junit.Assert.*;
import org.junit.Test;
import rUBERn.*;

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

}
