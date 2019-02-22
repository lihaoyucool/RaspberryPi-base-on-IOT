package com.raspberry.raspberry.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.raspberry.raspberry.entity.SensorData;
@Service
public interface RaspberryMongoRepository extends MongoRepository<SensorData, String>{

}
