import org.junit.Test;
import rUBERn.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by AlumnosFI on 15/10/2016.
 */
public class GpsTester {
    @Test
    public void locationTester(){
        Gps prueba = new Gps(10,20);
        Gps prueba2 = new Gps(20,10);
        long[] location = {10,20};
        long[] location2 = prueba.getLocation();
        assertEquals(location[0],location2[0] );
        assertEquals(location[1],location2[1] );


    }
    @Test
    public void distanceTester(){
        Gps prueba = new Gps(10,20);
        Gps prueba2 = new Gps(20,10);
        long[] location = {10,20};
        double distance = prueba.getDistance(prueba2.getLocation());
        assertEquals(15.14 , distance , 0.1);
    }
}
