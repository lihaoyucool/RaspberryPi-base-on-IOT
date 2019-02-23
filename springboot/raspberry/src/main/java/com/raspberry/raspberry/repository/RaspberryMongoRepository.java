package com.raspberry.raspberry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.raspberry.raspberry.repository.RaspberryMongoRepositoryEnhancement;
import org.springframework.stereotype.Service;

import com.raspberry.raspberry.entity.SensorData;
@Service
public interface RaspberryMongoRepository 
extends MongoRepository<SensorData, String>{
    
}
