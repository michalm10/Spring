package ug.app;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler {

    private final UpdateService updateService;

    public RequestHandler(UpdateService updateService) {
        this.updateService = updateService;
    }

    public Mono<ServerResponse> updateStream(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(updateService.updateStream(), SoftwareUpdate.class);

    }
}
