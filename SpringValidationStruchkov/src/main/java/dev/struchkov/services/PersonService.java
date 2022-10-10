package dev.struchkov.services;

import dev.struchkov.dtos.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Slf4j
@Service
@Validated
public class PersonService {

    public void save(@Valid PersonDto personDto){
        log.info("Saved {}", personDto);
    }

}
