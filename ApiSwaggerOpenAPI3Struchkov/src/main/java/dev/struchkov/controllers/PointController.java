package dev.struchkov.controllers;

import dev.struchkov.dtos.UserDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/points")
@Tag(name = "Point Controller", description = "My custom point controller")
public class PointController {

    private final Map<String, UserDto> repository;

    public PointController(Map<String, UserDto> repository) {
        this.repository = repository;
    }

    @PostMapping("{key}")
    public HttpStatus changePoints(
            @PathVariable String key,
            @RequestPart("point") Long point,
            @RequestPart("type") String type
    ) {
        final UserDto userDto = repository.get(key);
        userDto.setPoints(
                "plus".equalsIgnoreCase(type)
                        ? userDto.getPoints() + point
                        : userDto.getPoints() - point
        );
        return HttpStatus.OK;
    }

}
