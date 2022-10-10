package com.youtube.kirya522dev.repositories;

import com.youtube.kirya522dev.entities.Event;

public interface EventRepository {

    Event findEventById(long id);

    void saveEvent(Event event);
}
