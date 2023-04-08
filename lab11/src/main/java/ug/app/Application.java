package ug.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {
    Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner learning() {
        return args -> {

            WebClient.create("http://localhost:8080/").get()
                    .uri("updatestream")
                    .retrieve()
                    .bodyToFlux(SoftwareUpdate.class)
                    .subscribe(data -> logger.info(data.toString()));

            List<Integer> numbers = new ArrayList<>();

            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            numbers.add(4);
            numbers.add(5);
            numbers.add(6);
            numbers.add(7);
            numbers.add(8);

            // Non reactive Java Streams
            numbers.stream()
                    .filter(n -> n % 2 == 0)
                    .map(n -> n * 10)
                    .forEach(data -> logger.info("Java (non reactive) Stream: " + data.toString()));


            Flux.interval(Duration.ofSeconds(1))
                    .take(10)
                    .filter(n -> n % 2 == 0)
                    .map(n -> n * 10)
                    .subscribe(data -> logger.info("Reactive Stream: " + data.toString()));
        };
    }

}
