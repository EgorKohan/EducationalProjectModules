//package com.test.web.controllers;
//
//import com.jayway.jsonpath.DocumentContext;
//import com.jayway.jsonpath.JsonPath;
//import com.test.web.configs.MappingMapConfig;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    public UserController(MappingMapConfig mappingMap) {
//        this.mappingMap = mappingMap;
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "services.common")
//    public MappingMapConfig mappingMap() {
//        return new MappingMapConfig();
//    }
//
//    private final MappingMapConfig mappingMap;
//
//    @Data
//    private static class User {
//        private String name;
//        private String surname;
//        private Map<String, String> baba;
//    }
//
//    @PostMapping
//    public void create(@RequestBody Object object) {
//        System.out.println(object);
//        DocumentContext json = JsonPath.parse(object);
//        json.set("name", "Dima");
//        System.out.println(object);
//    }
//
//}
