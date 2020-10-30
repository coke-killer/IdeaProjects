package com.example.exceldemo.tool;

import com.example.exceldemo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExcelToolTest {
    @Autowired
    ExcelTool excelTool;

    @Test
    public void testWriteExcel() {
        String fileName = "C:/Users/于冬月/Desktop/text.xlsx";
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "hhh", "hhh.jpg", 1));
        teachers.add(new Teacher(1, "hhh", "hhh.jpg", 1));
        teachers.add(new Teacher(1, "hhh", "hhh.jpg", 1));
        teachers.add(new Teacher(1, "hhh", "hhh.jpg", 1));
        excelTool.writeExcel(fileName, Teacher.class, "第一位老师", teachers);
    }

    @Test
    public void readExcel() {
        String fileName = "C:/Users/于冬月/Desktop/hhhh.xlsx";
        excelTool.readExcel(fileName, Teacher.class);
    }
}