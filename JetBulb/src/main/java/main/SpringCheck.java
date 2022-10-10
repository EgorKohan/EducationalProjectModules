package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCheck {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
        System.out.println(context.getBeanDefinitionNames());
    }

}

