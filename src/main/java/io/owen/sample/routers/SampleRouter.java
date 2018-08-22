package io.owen.sample.routers;

import io.owen.sample.handlers.SampleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by owen_q on 2018. 8. 22..
 */

@Configuration
public class SampleRouter {
    private Logger logger = LoggerFactory.getLogger(SampleRouter.class);

    @Autowired
    private SampleHandler sampleHandler;

    @Bean
    public RouterFunction<ServerResponse> routes(){
        return RouterFunctions.route(
                RequestPredicates.POST("/sample")
                        .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON))
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
                , sampleHandler::echo);
    }

}
