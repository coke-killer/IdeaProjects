package com.example.demo.dao.impl;

import com.example.demo.dao.MongoDBDao;
import com.example.demo.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDBDaoImpl implements MongoDBDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveData(Device device, String collectionName) {
        mongoTemplate.insert(device, collectionName);
    }

    @Override
    public List<Device> selectDevices(String dataoffset, String category, String collectionName) {
        Query query = new Query(Criteria.where("dataoffset").is(dataoffset).and("category").is(category)).limit(300);
        List<Device> devices = mongoTemplate.find(query, Device.class, collectionName);
        return devices;
    }
}
