package main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import test.config.Config;

@Configuration
@Import(Config.class)
public class Config2 {


}
