package com.tccmicronaut;

import io.micronaut.runtime.EmbeddedApplication;
import jakarta.inject.Inject;

//@MicronautTest
class TccmicronautTest {

    @Inject
    EmbeddedApplication<?> application;

    //@Test
    void testItWorks() {
       // Assertions.assertTrue(application.isRunning());
    }

}
