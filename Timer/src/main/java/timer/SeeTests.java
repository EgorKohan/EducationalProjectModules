package timer;

import org.springframework.scheduling.annotation.Scheduled;

public class SeeTests {

    @Scheduled(fixedDelay = 100)
    public void printHello(){
        System.out.println("Hello");
    }




}
