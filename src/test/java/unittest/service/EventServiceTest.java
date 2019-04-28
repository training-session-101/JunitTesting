package unittest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import unittest.config.RestTemplateConfig;
import unittest.dto.Events;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest({EventService.class, RestTemplateConfig.class})
public class EventServiceTest {

    @Autowired
    private MockRestServiceServer mockServetusr;

    @Autowired
    private EventService eventService;

    @Test
    public void shouldReturnStubsEventsDetails(){
        mockServer.expect(requestTo("http://localhost:8090/events/v1")).andExpect(method(HttpMethod.GET)).andRespond(withSuccess(new ClassPathResource("events.json"), MediaType.APPLICATION_JSON));
        assertArrayEquals(eventService.getEvents().toArray(), asList(new Events(1,"Event 1")).toArray());
        assertTrue(eventService.getEvents().size() == 1);
    }
}