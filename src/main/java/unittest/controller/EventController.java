package unittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unittest.dto.Events;
import unittest.service.EventService;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping("/events/data")
    public List<Events> getAllEvents(){
        return  eventService.getEvents();
    }
}
