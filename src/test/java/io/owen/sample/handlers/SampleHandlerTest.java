package io.owen.sample.handlers;

import io.owen.sample.payload.Person;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.Duration;


/**
 * Created by owen_q on 2018. 8. 22..
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleHandlerTest {
    @Autowired
    private ApplicationContext applicationContext;

//    @Autowired
    private WebTestClient webTestClient;

    @org.junit.jupiter.api.Test
    public void test_post() {
        webTestClient = WebTestClient.bindToApplicationContext(applicationContext).configureClient().responseTimeout(Duration.ofHours(1)).build();

        Person person = new Person("Webflux Tester");

        webTestClient.post().uri("/sample")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(person), Person.class)
                .exchange().expectStatus().isOk();
    }
}