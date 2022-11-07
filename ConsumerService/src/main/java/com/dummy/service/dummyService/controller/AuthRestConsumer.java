package com.dummy.service.dummyService.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("authentication-service/auth")
public interface AuthRestConsumer {
    @GetMapping(value="/getToken/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String createToken(@PathVariable("id") int id);
}
