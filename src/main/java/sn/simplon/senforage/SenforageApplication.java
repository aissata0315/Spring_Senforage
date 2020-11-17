package sn.simplon.senforage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SenforageApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SenforageApplication.class, args);
    }

}
