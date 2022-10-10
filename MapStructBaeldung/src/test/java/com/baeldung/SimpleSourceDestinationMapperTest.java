package com.baeldung;

import com.baeldung.mappers.SimpleSourceDestinationMapper;
import com.baeldung.models.SimpleDestination;
import com.baeldung.models.SimpleSource;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SimpleSourceDestinationMapperTest {

    private SimpleSourceDestinationMapper simpleSourceDestinationMapper =
            Mappers.getMapper(SimpleSourceDestinationMapper.class);

    @Disabled
    @Test
    void givenSourceToDestination_whenMaps_thenCorrect() {
        SimpleSource simpleSource = new SimpleSource();
        simpleSource.setName("SourceName");
        simpleSource.setDescription("SourceDescription");
        SimpleDestination simpleDestination = simpleSourceDestinationMapper.sourceToDestination(simpleSource);

        assertThat(simpleSource.getName(), is(simpleDestination.getName()));
        assertThat(simpleSource.getDescription(), is(simpleDestination.getDescription()));

    }

    @Test
    void givenDestinationToSource_whenMaps_thenCorrect() {
        SimpleDestination simpleDestination = new SimpleDestination();
        simpleDestination.setName("SourceName");
        simpleDestination.setDescription("SourceDescription");
        SimpleSource simpleSource = simpleSourceDestinationMapper.destinationToSource(simpleDestination);

        assertThat(simpleDestination.getName(), is(simpleSource.getName()));
        assertThat(simpleDestination.getDescription(), is(simpleSource.getDescription()));
    }

}
