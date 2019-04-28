package unittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import unittest.dto.Events;

import java.util.List;

@Service
public class EventService {

    private final String url = "http://localhost:8090/events/v1";

    @Autowired
    private RestTemplate restTemplate;


    public List<Events> getEvents() {
        ResponseEntity<List<Events>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Events>>() {
        });
        return responseEntity.getBody();
    }
}
