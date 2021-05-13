package com.xiao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.entity.dto.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaojw
 * @describe StudentDao
 * @date 2021/4/14 11:23
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
