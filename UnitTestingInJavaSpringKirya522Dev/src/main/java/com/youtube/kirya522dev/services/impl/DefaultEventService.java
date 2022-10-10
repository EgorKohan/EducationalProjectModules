package com.youtube.kirya522dev.services.impl;

import com.youtube.kirya522dev.entities.Event;
import com.youtube.kirya522dev.repositories.EventRepository;
import com.youtube.kirya522dev.services.EventService;
import org.springframework.stereotype.Service;

@Service
public class DefaultEventService implements EventService {

    private final EventRepository eventRepository;

    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event findEvent(long id) {
        return eventRepository.findEventById(id);
    }

    @Override
    public void saveEvent(Event event) {
        eventRepository.saveEvent(event);
    }
}
