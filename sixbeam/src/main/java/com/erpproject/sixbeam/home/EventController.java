package com.erpproject.sixbeam.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventEntity> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public EventEntity addEvent(@RequestBody EventEntity event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/{eventId}")
    public EventEntity updateEvent(@PathVariable("eventId") Long eventId, @RequestBody EventEntity event) {
        // Ensure the event ID matches the path variable
        if (!eventId.equals(event.getId())) {
            throw new IllegalArgumentException("Event ID in path must match the ID in the request body");
        }
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
