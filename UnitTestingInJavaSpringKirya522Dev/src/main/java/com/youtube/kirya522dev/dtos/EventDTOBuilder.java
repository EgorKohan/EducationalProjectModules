package com.youtube.kirya522dev.dtos;

import com.youtube.kirya522dev.entities.Event;

public interface EventDTOBuilder {
    EventDTO fromEvent(Event event);

    Event fromEventDTO(EventDTO eventDTO);
}
