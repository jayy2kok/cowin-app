package com.example.cowin.cowinapp.configuration;

import com.cowin.jayy2kok.client.api.AppointmentAvailabilityApisApi;
import com.cowin.jayy2kok.client.invoker.ApiClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    AppointmentAvailabilityApisApi availabilityApi(){
        return new  AppointmentAvailabilityApisApi(new ApiClient());
    }
}
