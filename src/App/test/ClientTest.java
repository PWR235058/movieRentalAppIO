package App.test;

import App.Resources.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

public class ClientTest {
    Client client;

    @Rule
    public ExpectedException expection = ExpectedException.none();

    @Before
    public void setUp(){
        client = new Client(1,"user", "password", "firstName", "lastName");
    }

    @Category({ClientTTest.class})
    @Test
    public void shouldCreateInstance(){
        Assertions.assertTrue(client != null);
    }


    @Category({ClientTTest.class})
    @Test
    public void gettersShouldReturnPropperValues(){
        Assertions.assertEquals("firstName", client.getFirstName());
        Assertions.assertEquals(1, client.getId());
        Assertions.assertEquals("user", client.getUserName());
        Assertions.assertEquals("password", client.getPassword());
        Assertions.assertEquals("lastName", client.getLastName());
    }


}
