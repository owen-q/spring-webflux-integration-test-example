package io.owen.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by owen_q on 2018. 8. 22..
 */

@SpringBootApplication
@EnableAutoConfiguration
//@EnableWebFlux
//@ComponentScan("")
public class SampleApplication {
    private Logger logger = LoggerFactory.getLogger(SampleApplication.class);

    public static void main(String[] args){
        SpringApplication.run(SampleApplication.class, args);
    }
}
