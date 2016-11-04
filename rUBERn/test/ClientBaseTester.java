import org.junit.*;
import org.junit.rules.*;

import exceptions.AlreadyRegisteredException;
import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
import exceptions.NotEnoughMoneyException;
import logic.*;

import static org.junit.Assert.*;

/**
 * Created by AlumnosFI on 14/10/2016.
 */
public class ClientBaseTester {
	@Rule
	public ExpectedException exception = ExpectedException.none();
    @Test
    public void addUserTester() throws EmptyFieldException{
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "hola");
        sistema.addUser(Tomas);
        
    }
    @Test
    public void addUserFailTester() throws EmptyFieldException{
    	exception.expect(EmptyFieldException.class);
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("" , 12345, "gola");
        boolean result = !sistema.addUser(Tomas);
        assertTrue(result);
    }
    @Test
    public void removeUserTester() throws EmptyFieldException, ItemNotFoundException{
    	exception.expect(ItemNotFoundException.class);
    	DriverBase baseDeChoferes = new DriverBase();
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos, baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "hola");
        sistema.addUser(Tomas);
        sistema.removeUser(Tomas);
        sistema.getUser(Tomas.getName());

    }
    @Test
    public void removeUserFailTester() throws EmptyFieldException, ItemNotFoundException{
    	exception.expect(ItemNotFoundException.class);
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
    public void testCheckPassword() throws EmptyFieldException{
        ClientBase basededatos = new ClientBase();
        DriverBase baseDeChoferes = new DriverBase();
        Matrix sistema = new Matrix(basededatos,baseDeChoferes);
        User Tomas = new User("Tomas" , 12345, "macarena");
        sistema.addUser(Tomas);
        assertTrue(sistema.checkPassword("tomas","macarena"));
    }
}
