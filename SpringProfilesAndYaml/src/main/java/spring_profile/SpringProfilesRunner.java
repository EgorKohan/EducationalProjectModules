package spring_profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "spring_profile")
public class SpringProfilesRunner {

    public static void main(String[] args) {
//        SpringApplication.setAdditionalProfiles("dev");
        SpringApplication.run(SpringProfilesRunner.class, args);
    }

}
