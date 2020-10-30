package com.example.exceldemo.tool;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.exceldemo.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

// 有个很重要的点 ExcelListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class ExcelListener extends AnalysisEventListener<Teacher> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    /**
     * 这个集合用于接收 读取Excel文件得到的数据
     */
    List<Teacher> list = new ArrayList<Teacher>();

    /**
     * 假设这个是一个Entity，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private Teacher teacher;

    public ExcelListener() {

    }

    /**
     * 不要使用自动装配
     * 在测试类中将Entity当参数传进来
     */
    public ExcelListener(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(Teacher teacher, AnalysisContext context) {
        list.add(teacher);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
//        在这个地方可以调用dao  我们就直接打印数据了
        System.out.println(list);
    }
}