import org.junit.Test;
import rUBERn.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by AlumnosFI on 14/10/2016.
 */
public class UserTester {
    @Test
    public void addUserTester(){
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos);
        User Tomas = new User("Tomas" , 12345);
        sistema.addUser(Tomas);
        assertEquals(sistema.getUser(Tomas.getName()), Tomas );
    }
    @Test
    public void removeUserTester(){
        ClientBase basededatos = new ClientBase();
        Matrix sistema = new Matrix(basededatos);
        User Tomas = new User("Tomas" , 12345);
        sistema.addUser(Tomas);
        sistema.removeUser(Tomas);
        assertEquals(sistema.getUser(Tomas.getName()), null);

    }
}
