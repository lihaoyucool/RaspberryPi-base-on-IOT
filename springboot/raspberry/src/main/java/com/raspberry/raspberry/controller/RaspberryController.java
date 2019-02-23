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

import com.raspberry.raspberry.config.MqttGateway;
import com.raspberry.raspberry.config.MqttProperties;
import com.raspberry.raspberry.entity.SensorData;
import com.raspberry.raspberry.repository.RaspberryMongoRepository;

@Controller
@RestController
@RequestMapping("/raspberry")
public class RaspberryController {
    @Autowired
    RaspberryMongoRepository mongoRepository;
    
    @Autowired
    private MqttGateway mqttGateway;
    
    @Autowired 
    MqttProperties mqttConfig;
    
    //create
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpHeaders create(@RequestBody SensorData asset) {
       HttpHeaders httpHeaders = new HttpHeaders();
       mqttGateway.sendToMqtt(mqttConfig.getInbound().getTopics(), asset.getNumber());
       mongoRepository.save(asset);
       return httpHeaders;
    }
    //get
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public SensorData get(@PathVariable String id) {
        SensorData userData = mongoRepository.findOne(id);
        return userData;
    }
    //Update
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody SensorData asset) {
        mongoRepository.save(asset);
    }
    
    //delete
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        mongoRepository.delete(id);
    }
}
