package com.tccmicronaut.delivery;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Date;

@Controller("/health")
public class HealthController {

    @Get
    String index() {
        return new Date().toString();
    }
}