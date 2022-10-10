package com.youtube.kirya522dev.dtos.impl;

import com.youtube.kirya522dev.dtos.EventDTO;
import com.youtube.kirya522dev.dtos.EventDTOBuilder;
import com.youtube.kirya522dev.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class DefaultEventDTOBuilder implements EventDTOBuilder {

    public EventDTO fromEvent(Event event) {
        return new EventDTO() {{
            setId(event.getId());
            setName(event.getName());
            setStartDate(event.getStartDate());
            setEndDate(event.getEndDate());
        }};
    }

    @Override
    public Event fromEventDTO(EventDTO eventDTO) {
        return new Event(eventDTO.getId(),
                eventDTO.getName(),
                eventDTO.getStartDate(),
                eventDTO.getEndDate()
        );
    }
}
