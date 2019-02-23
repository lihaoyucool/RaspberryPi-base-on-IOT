package com.raspberry.raspberry.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.raspberry.raspberry.entity.SensorData;
import com.raspberry.raspberry.repository.RaspberryMongoRepositoryEnhancement;

public class MongoRepositoryImpl implements RaspberryMongoRepositoryEnhancement{
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public int updateAssetByFileds(String id, SensorData fields) {
        return 0;
    }
}
