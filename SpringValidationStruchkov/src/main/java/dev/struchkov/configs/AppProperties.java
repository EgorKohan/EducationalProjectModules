package dev.struchkov.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Validated
@ConfigurationProperties(prefix = "app.properties")
public class AppProperties {

    @NotEmpty
    private String name;

    @Min(7)
    @Max(30)
    private Integer reportIntervalInDays;

    @Email
    private String reportEmailAddress;

}
