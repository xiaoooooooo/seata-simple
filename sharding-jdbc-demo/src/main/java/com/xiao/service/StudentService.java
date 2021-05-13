package com.xiao.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.dao.StudentDao;
import com.xiao.entity.dto.Student;
import org.springframework.stereotype.Service;

/**
 * @author xiaojw
 * @describe StudentService
 * @date 2021/4/14 11:16
 */
@Service
public class StudentService extends ServiceImpl<StudentDao, Student> {
}
