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
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "hola");
        sistema.addUser(Tomas);
        
    }
    @Test
    public void addUserFailTester(){
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("" , 12345, "gola");
        boolean result = !sistema.addUser(Tomas);
        assertTrue(result);
    }
    @Test
    public void removeUserTester(){
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "hola");
        sistema.addUser(Tomas);
        sistema.removeUser(Tomas);
        assertNull(sistema.getUser(Tomas.getName()));

    }
    @Test
    public void removeUserFailTester(){
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "dsfgv");
        User Mario = new User("Mario" , 12345, "sdsdf");
        sistema.addUser(Tomas);
        sistema.removeUser(Mario);
        assertEquals(Tomas, sistema.getUser(Tomas.getName()));

    }
    @Test
    public void testCheckPassword(){
        ClientBase basededatos = new ClientBase();
        DriverBase baseDeChoferes = new DriverBase();
        Matrix sistema = new Matrix(basededatos,baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "macarena");
        sistema.addUser(Tomas);
        assertTrue(sistema.checkPassword("tomas","macarena"));
    }
}
