package com.raspberry.raspberry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.raspberry.raspberry.MongoRepository.RaspberryMongoRepository;
import com.raspberry.raspberry.entity.SensorData;

@Controller
@RestController
@RequestMapping("/raspberry")
public class RaspberryController {
    @Autowired
    RaspberryMongoRepository mongoRepository;
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpHeaders create(@RequestBody SensorData asset) {
       HttpHeaders httpHeaders = new HttpHeaders();
       mongoRepository.save(asset);
       return httpHeaders;
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public SensorData get(@PathVariable String id) {
        SensorData userData = mongoRepository.findOne(id);
        return userData;
    }
    
    
}
