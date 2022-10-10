package dev.struchkov.dtos;

import dev.struchkov.custom.constraints.CapitalLetter;
import dev.struchkov.validation.Marker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto2 {

    @Null(groups = {Marker.OnCreate.class})
    @NotNull(groups = {Marker.OnUpdate.class})
    private Long id;

    @NotBlank
    @CapitalLetter
    private String name;


}
