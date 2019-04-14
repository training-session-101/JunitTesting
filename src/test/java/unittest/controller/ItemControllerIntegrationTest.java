package unittest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //loads the application context
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the data from data.sql file and starts the app at random port.
@TestPropertySource(locations = "classpath:application.properties") //loads the config from the specified location
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnOKStatus() throws Exception{
        String actualResponse = testRestTemplate.getForObject("/item?id=1",String.class);
        String expectedResponse = "{id:1,name:Item1,price:12,quantity:23}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }
}
