package com.example.demo.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.context.WriteContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.event.WriteHandler;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.ExcelBuilderImpl;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2019/8/29 11:00
 * @Description TODO
 **/
@Component
public class EasyExcelUtil {

    public static String excelFilePath = "C:\\Users\\yudongyue\\Desktop\\Jay01-(jay01)-v5自定义导入数据.xls";

    public static void writeExcel(String excelFile) throws IOException {
        // 文件输出位置
        OutputStream out = new FileOutputStream(excelFile);
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");
        // 创建一个表格，用于 Sheet 中使用
        Table table1 = new Table(1);
        // 无注解的模式，动态添加表头
        table1.setHead(createTestListStringHead());
        // 写数据
        writer.write1(new ArrayList<>(), sheet1, table1);

        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet2 = new Sheet(2, 0);
        sheet2.setSheetName("第2个sheet");
/*
        添加TableStyle属性会使内存OOM
        TableStyle tableStyle = new TableStyle();
        com.alibaba.excel.metadata.Font font = new com.alibaba.excel.metadata.Font();
        font.setBold(true);
        tableStyle.setTableContentFont(font);
        sheet2.setTableStyle(tableStyle);
*/
        // 创建一个表格，用于 Sheet 中使用
        Table table2 = new Table(2);
        // 无注解的模式，动态添加表头
        table2.setHead(createTestListStringHead());
        writer.write1(new ArrayList<>(), sheet2, table2);
        int x = 0;
        while (x < 10000) {
            System.out.println("x = " + x);
            Table tableX = new Table(1);
            sheet1.setStartRow(x);
            writer.write1(createDynamicModelList(x), sheet1, tableX);

            Table tableX2 = new Table(1);
            sheet2.setStartRow(x);
            writer.write1(createDynamicModelList(x), sheet2, tableX2);
            x = x + 100;
        }
        //获取workbook，隐藏第2页sheet
        Workbook workbook = getWorkbook(writer);
        workbook.setSheetHidden(1, false);
        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();
        // 关闭流
        out.close();
    }

    // 无注解的模式，动态添加表头
    public static List<List<String>> createTestListStringHead() {
        // 模型上没有注解，表头数据动态传入
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();
        List<String> headCoulumn5 = new ArrayList<String>();
        headCoulumn1.add("第1列");
        headCoulumn2.add("第2列");
        headCoulumn3.add("第3列");
        headCoulumn4.add("第4列");
        headCoulumn5.add("第5列");
        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);
        head.add(headCoulumn5);
        return head;
    }

    private static List<List<Object>> createDynamicModelList(int x) {
        List<List<Object>> rows = new ArrayList<>();
        for (int i = x; i < 100 + x; i++) {
            List<Object> row = new ArrayList<>();
            row.add("字符串-" + i);
            row.add(Long.valueOf(187837834L) + i);
            row.add(Integer.valueOf(2233 + i));
            row.add("宁-" + i);
            row.add("微信公众号： demo");
            rows.add(row);
        }
        return rows;
    }

    /**
     * **获取workbook**
     * 因为EasyExcel这个库设计的原因
     * 只能使用反射获取workbook
     *
     * @param writer
     * @return
     */
    private static Workbook getWorkbook(ExcelWriter writer) {
        Workbook workbook = null;
        try {
            Class<?> clazz1 = Class.forName("com.alibaba.excel.ExcelWriter");
            Field[] fs = clazz1.getDeclaredFields();
            for (Field field : fs) {
                // 要设置属性可达，不然会抛出IllegalAccessException异常
                field.setAccessible(true);
                if ("excelBuilder".equals(field.getName())) {
                    ExcelBuilderImpl excelBuilder = (ExcelBuilderImpl) field.get(writer);
                    Class<?> clazz2 = Class.forName("com.alibaba.excel.write.ExcelBuilderImpl");
                    Field[] fs2 = clazz2.getDeclaredFields();
                    for (Field field2 : fs2) {
                        field2.setAccessible(true);
                        if ("context".equals(field2.getName())) {
                            WriteContext context = (WriteContext) field2.get(excelBuilder);
                            workbook = context.getWorkbook();
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static void writeExcelToSheet(String excelFile, Sheet sheet1, Sheet sheet2) throws IOException {
        // 文件输出位置
        OutputStream out = new FileOutputStream(excelFile);
        ExcelWriter writer = EasyExcelFactory.getWriterWithTempAndHandler(null, out, ExcelTypeEnum.XLS, true, new WriteHandler() {
            @Override
            public void sheet(int i, org.apache.poi.ss.usermodel.Sheet sheet) {
                sheet.setColumnHidden(0, false);
                sheet.setColumnHidden(1, false);
            }

            @Override
            public void row(int i, Row row) {
                System.out.println("row : " + row.getRowNum());
            }

            @Override
            public void cell(int i, Cell cell) {
                System.out.println("cell : " + i);
            }
        });
        Table table1 = new Table(1);
        Table table2 = new Table(2);
        table1.setHead(createTestListStringHead());// 写数据
        table2.setHead(createTestListStringHead());
        writer.write1(createDynamicModelList(0), sheet1, table1);
        writer.write1(createDynamicModelList(0), sheet2, table2);
        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();
        // 关闭流
        out.close();
    }

    public static void main(String[] args) {
        try {
//            writeExcel(excelFilePath);
            Sheet sheet1 = new Sheet(1, 0);
            Sheet sheet2 = new Sheet(2, 0);
            sheet1.setSheetName("第一个sheet");
            sheet2.setSheetName("第二个sheet");
            writeExcelToSheet("C:\\Users\\yudongyue\\Desktop\\Jay01.xls", sheet1, sheet2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}