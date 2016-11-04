
import org.junit.Test;

import logic.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by AlumnosFI on 15/10/2016.
 */
public class GpsTester {
    @Test
    public void locationTester(){
        Gps prueba = new Gps(10,20);
        long[] location = {10,20};
        long[] location2 = prueba.getLocation();
        assertEquals(location[0],location2[0] );
        assertEquals(location[1],location2[1] );
    }
    @Test
    public void distanceTester(){
        Gps prueba = new Gps(10,20);
        Gps prueba2 = new Gps(20,10);
        double distance = prueba.getDistance(prueba2.getLocation());
        assertEquals(14.14 , distance , 0.1);
    }
    @Test
    public void updateLocationTester(){
        Gps prueba = new Gps(10,20);
        long[] location = {34,20};
        prueba.updateLocation(34, 20);
        long[] newLocation = prueba.getLocation();
        assertEquals(location[0],newLocation[0] );
        assertEquals(location[1],newLocation[1] );
    }
}
