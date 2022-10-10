package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import main.A;
import main.B;

//@Configuration
public class Config {

    @Bean
//    @Scope("prototype")
    public A a() {
        return new A();
    }

    @Bean
    public A a1() {
        return new A();
    }

    @Bean
    public B b(A a, A a1) {
        return new B(a, a1);
    }

}
