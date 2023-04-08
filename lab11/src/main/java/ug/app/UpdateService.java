package ug.app;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ug.app.domain.Smartphone;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UpdateService {

    public Flux<SoftwareUpdate> updateStream() {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

        Flux<SoftwareUpdate> events = Flux.fromStream(Stream.generate(() -> new SoftwareUpdate(
                new Smartphone(
                    UUID.randomUUID().toString(),
                    "10T",
                    null,
                    256,
                    16
                )
                , LocalDateTime.now())));

        return Flux.zip(events, interval, (e, i) -> e);

    }
}

