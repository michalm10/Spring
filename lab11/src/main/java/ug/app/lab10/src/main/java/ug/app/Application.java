package ug.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ug.app.domain.Smartphone;
import ug.app.service.SmartphoneManager;

import java.util.UUID;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner appSetup(@Autowired SmartphoneManager smartphoneManager){
        return args -> {
            smartphoneManager.learning();
        };
    }
}
