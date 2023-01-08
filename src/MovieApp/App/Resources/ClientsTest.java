package App.Resources;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientsTest {
    @Test
    public void byDefaultListOfClientsShouldBeEmpty(){
        assertEquals(0, Clients.getInstance().getClients().size());
    }

    @Test
    public void shouldAddNewClient(){
        Clients.getInstance().addClient("Grzegorz123", "123","Grzegorz","nieGrzegorz");
        assertEquals(1, Clients.getInstance().getClients().size());
        assertEquals("Grzegorz",Clients.getInstance().getClients().get(0).getFirstName());
        assertEquals("Grzegorz123",Clients.getInstance().getClients().get(0).getUserName());
        assertEquals("nieGrzegorz",Clients.getInstance().getClients().get(0).getLastName());
        assertEquals("123",Clients.getInstance().getClients().get(0).getPassword());
        assertEquals(1,Clients.getInstance().getClients().get(0).getId());
    }

    @Test
    public void filteringShouldWorkCorrectly(){

        Clients.getInstance().addClient("Grzegorz123", "123","Grzegorz","nieGrzegorz");
        Clients.getInstance().addClient("Grzegorz125", "125","Grzegorz","takGrzegorz");
        Clients.getInstance().addClient("Krzysztof123", "123","Krzysztof","nieKrzysztof");
        Clients.getInstance().addClient("Maciej123", "123","Maciej","nieMaciej");

        assertEquals(4, Clients.getInstance().searchClients("","","").size());
        assertEquals(2, Clients.getInstance().searchClients("Grzegorz","","").size());
        assertEquals(1, Clients.getInstance().searchClients("Grzegorz123","","").size());
        assertEquals(3, Clients.getInstance().searchClients("123","","").size());
        assertEquals(1, Clients.getInstance().searchClients("123","Maciej","").size());
        assertEquals(1, Clients.getInstance().searchClients("","Maciej","").size());
        assertEquals(0, Clients.getInstance().searchClients("","Maciej123","").size());
        assertEquals(0, Clients.getInstance().searchClients("","Maciej123","nie").size());
        assertEquals(3, Clients.getInstance().searchClients("","","nie").size());

    }
}