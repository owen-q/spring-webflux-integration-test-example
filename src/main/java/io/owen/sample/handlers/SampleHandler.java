package io.owen.sample.handlers;

import io.owen.sample.payload.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by owen_q on 2018. 8. 22..
 */
@Component
public class SampleHandler {
    private Logger logger = LoggerFactory.getLogger(SampleHandler.class);

    public Mono<ServerResponse> echo(ServerRequest serverRequest){
        Mono<Person> mono = serverRequest.bodyToMono(Person.class);

        mono.subscribe(s -> {
            if(logger.isInfoEnabled())
                logger.info(s.getName());
        });

        return ServerResponse.ok().body(BodyInserters.fromObject("Hello World"));
    }
}
