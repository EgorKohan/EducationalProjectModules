package com.youtube.kirya522dev.repositories.impl;

import com.youtube.kirya522dev.entities.Event;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DefaultInMemoryEventRepositoryTest {

    private static final long ID = 1L;

    private DefaultInMemoryEventRepository repository;

    @BeforeEach
    void setUp() {
        repository = new DefaultInMemoryEventRepository();
    }

    @Test
    void findEventById_shouldFindEvent_whenExists() {
        final Event event = Mockito.mock(Event.class);
        Mockito.when(event.getId()).thenReturn(ID);

        repository.saveEvent(event);
        final Event actual = repository.findEventById(ID);

        MatcherAssert.assertThat(actual, Matchers.notNullValue());
        MatcherAssert.assertThat(actual, Matchers.equalTo(event));
    }

}