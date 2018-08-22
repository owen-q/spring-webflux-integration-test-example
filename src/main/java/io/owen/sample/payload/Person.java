package io.owen.sample.payload;

import java.io.Serializable;

/**
 * Created by owen_q on 2018. 8. 22..
 */
public class Person implements Serializable {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
