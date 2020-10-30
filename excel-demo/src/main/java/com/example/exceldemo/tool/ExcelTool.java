package com.example.exceldemo.tool;

import com.alibaba.excel.EasyExcel;
import com.example.exceldemo.entity.Teacher;
import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExcelTool {
    // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    // 如果这里想使用03 则 传入excelType参数即可
    public void writeExcel(String fileName, Class clazz, String sheetName, List list) {
        EasyExcel.write(fileName, clazz).sheet(sheetName).doWrite(list);
    }

    @SneakyThrows
    public void readExcel(String fileName, Class clazz) {
        EasyExcel.read(fileName, clazz, new ExcelListener((Teacher) clazz.newInstance())).sheet().doRead();
    }
}
