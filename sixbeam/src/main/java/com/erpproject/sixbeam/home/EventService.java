package com.erpproject.sixbeam.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventEntity addEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public EventEntity updateEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }
}