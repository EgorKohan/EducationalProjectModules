package com.youtube.kirya522dev.controllers;

import com.youtube.kirya522dev.dtos.EventDTO;
import com.youtube.kirya522dev.dtos.EventDTOBuilder;
import com.youtube.kirya522dev.entities.Event;
import com.youtube.kirya522dev.services.EventService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("event")
public class EventsController {
    private final EventDTOBuilder eventDTOBuilder;
    private final EventService eventService;

    public EventsController(EventDTOBuilder eventDTOBuilder, EventService eventService) {
        this.eventDTOBuilder = eventDTOBuilder;
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public EventDTO getEvent(@PathVariable("id") long eventId) {
        final Event event = eventService.findEvent(eventId);
        return eventDTOBuilder.fromEvent(event);
    }

    @PutMapping
    public void saveEvent(@RequestBody @Validated EventDTO eventDTO) {
        final Event event = eventDTOBuilder.fromEventDTO(eventDTO);
        eventService.saveEvent(event);
    }
}
