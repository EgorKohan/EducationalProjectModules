package com.youtube.kirya522dev.services.impl;

import com.youtube.kirya522dev.entities.Event;
import com.youtube.kirya522dev.repositories.EventRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultEventServiceTest {

    private static final long ID = 1L;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private DefaultEventService service;

    @Test
    void findEvent_shouldCallRepository() {
        final Event event = Mockito.mock(Event.class);
        Mockito.when(eventRepository.findEventById(ID)).thenReturn(event);

        final Event actual = service.findEvent(ID);

        MatcherAssert.assertThat(actual, Matchers.notNullValue());
        MatcherAssert.assertThat(event, Matchers.equalTo(actual));
        Mockito.verify(eventRepository).findEventById(ID);
    }

}