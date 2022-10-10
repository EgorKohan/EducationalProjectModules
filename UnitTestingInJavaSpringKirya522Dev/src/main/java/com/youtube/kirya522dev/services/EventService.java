package com.youtube.kirya522dev.services;

import com.youtube.kirya522dev.entities.Event;

public interface EventService {

    Event findEvent(long id);

    void saveEvent(Event event);
}
