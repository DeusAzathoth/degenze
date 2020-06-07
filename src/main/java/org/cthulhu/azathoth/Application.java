package org.cthulhu.azathoth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

//    TODO
//    Database logger


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
