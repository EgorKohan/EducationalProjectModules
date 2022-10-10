package com.baeldung.mappers;

import com.baeldung.models.SimpleDestination;
import com.baeldung.models.SimpleSource;
import com.baeldung.services.SimpleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SimpleSourceDestinationMapper {

    @Autowired
    protected SimpleService simpleService;

    @Mapping(target = "name", expression = "java(simpleService.enrichName(simpleSource.getName()))")
    public abstract SimpleDestination sourceToDestination(SimpleSource simpleSource);

    public abstract SimpleSource destinationToSource(SimpleDestination simpleDestination);

}
