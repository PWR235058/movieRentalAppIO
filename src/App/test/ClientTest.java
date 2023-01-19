package App.test;

import App.Interface.WorkerApp;
import App.Resources.Client;
import App.Resources.Clients;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class ClientTest {
    Client client;
    WorkerApp workerApp;

    @Rule
    public ExpectedException expection = ExpectedException.none();

    @Before
    public void setUp(){
        client = new Client(1,"user", "password", "firstName", "lastName");
        workerApp = new WorkerApp();
    }

    @Category({ClientTTest.class})
    @Test
    public void shouldCreateInstance(){
        Assertions.assertTrue(client != null);
    }


    @Category({ClientTTest.class})
    @Test
    public void gettersShouldReturnProperValues(){
        Assertions.assertEquals("firstName", client.getFirstName());
        Assertions.assertEquals(1, client.getId());
        Assertions.assertEquals("user", client.getUserName());
        Assertions.assertEquals("password", client.getPassword());
        Assertions.assertEquals("lastName", client.getLastName());
    }

    @Category({ClientTTest.class})
    @Test
    public void checkAddingClient(){
        Assertions.assertNotNull(workerApp);
        workerApp.registerClient("usertest", "pass", "User","Test");
        client = Clients.getInstance().getClientById(1);
        Assertions.assertEquals("usertest", client.getUserName());
        Assertions.assertEquals("pass", client.getPassword());
        Assertions.assertEquals("User", client.getFirstName());
        Assertions.assertEquals("Test", client.getLastName());
    }


}
