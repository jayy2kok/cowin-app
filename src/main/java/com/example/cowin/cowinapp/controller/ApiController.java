package com.example.cowin.cowinapp.controller;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import com.cowin.jayy2kok.client.api.AppointmentAvailabilityApisApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ApiController {
    @Autowired
	AppointmentAvailabilityApisApi availabilityApi;

    @GetMapping("/bypin")
    public Mono<Object> test(@RequestParam String pin){
        Date tomorrow = Date.from(Instant.now().plus(Duration.ofDays(1)));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         log.info("calling api for pin={"+pin+"} date={"+formatter.format(tomorrow)+"}");
        return availabilityApi.findByPin(pin, formatter.format(tomorrow), "en_IN");
    }

}
