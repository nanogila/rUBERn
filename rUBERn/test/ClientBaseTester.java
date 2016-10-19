import org.junit.*;
import org.junit.rules.*;

import logic.*;

import static org.junit.Assert.*;

/**
 * Created by AlumnosFI on 14/10/2016.
 */
public class ClientBaseTester {
	@Rule
	public ExpectedException exception = ExpectedException.none();
    @Test
    public void addUserTester(){
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos);
        User Tomas = new User("Tomas" , 12345);
        sistema.addUser(Tomas);
        
    }
    @Test
    public void addUserFailTester(){
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos);
        User Tomas = new User("" , 12345);
        boolean result = !sistema.addUser(Tomas);
        assertTrue(result);
    }
    @Test
    public void removeUserTester(){
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos);
        User Tomas = new User("Tomas" , 12345);
        sistema.addUser(Tomas);
        sistema.removeUser(Tomas);
        assertNull(sistema.getUser(Tomas.getName()));

    }
    @Test
    public void removeUserFailTester(){
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos);
        User Tomas = new User("Tomas" , 12345);
        User Mario = new User("Mario" , 12345);
        sistema.addUser(Tomas);
        sistema.removeUser(Mario);
        assertEquals(Tomas, sistema.getUser(Tomas.getName()));

    }
}
