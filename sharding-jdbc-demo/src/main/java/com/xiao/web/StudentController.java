package com.xiao.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiao.entity.dto.Student;
import com.xiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

/**
 * @author xiaojw
 * @describe StudentController
 * @date 2021/4/14 11:10
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public String insert(@RequestBody Student student){
        boolean save = studentService.save(student);
        return save?"success":"error";
    }
    public Student select(@RequestBody Student student){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(true,"name","xiao");
        Student stu = studentService.getOne(wrapper);
        return stu;
    }
}
