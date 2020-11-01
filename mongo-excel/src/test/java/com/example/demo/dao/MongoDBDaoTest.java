package com.example.demo.dao;

import com.example.demo.dao.impl.MongoDBDaoImpl;
import com.example.demo.entity.Device;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MongoDBDaoTest {
    @Autowired
    MongoDBDaoImpl mongoDBDaoImpl;

    @SneakyThrows
    @Test
    void saveData() {
        for (int i = 0; i < 500; i++) {
            mongoDBDaoImpl.saveData(new Device("15"+i, "4", "20", System.currentTimeMillis()), "2");
            Thread.sleep(5);
        }
    }
}