package com.tccmicronaut;

import com.tccmicronaut.model.User;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
