package com.example.demo.dao;

import com.example.demo.entity.Device;

import java.util.List;

public interface MongoDBDao {
    void saveData(Device device,String collectionName);

    List<Device> selectDevices(String dataoffset, String category, String collectionName);
}
