import static org.junit.Assert.assertEquals;

import org.junit.Test;
import logic.*;

public class AppraiserTester {
	@Test
	public void appraiseCarTest() {
		Car fiat = new Fiat600();
		Appraiser tasador = new Appraiser();
		
		
		assertEquals(0.2, tasador.appraiseCar(fiat), 0.00000001);
	}
}
