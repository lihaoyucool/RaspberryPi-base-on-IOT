package com.raspberry.raspberry.repository;

import com.raspberry.raspberry.entity.SensorData;

public interface RaspberryMongoRepositoryEnhancement {
    int updateAssetByFileds(String id, SensorData fields);
}
