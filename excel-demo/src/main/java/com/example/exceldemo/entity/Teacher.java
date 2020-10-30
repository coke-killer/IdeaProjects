package com.example.exceldemo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    /**
     * 老师的主键
     */
    @ExcelIgnore
    private Integer teacherId;
    /**
     * 名字
     */
    @ExcelProperty("老师名字")
    private String teacherName;
    /**
     * 头像图片地址
     */
    @ExcelProperty("老师图片")
    private String teacherImage;
    /**
     * 老师的状态 0代表正常 1代表删除
     */
    @ExcelProperty("老师状态 ")
    private Integer teacherStatus;
}