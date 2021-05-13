package com.xiao.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaojw
 * @describe StudentDTO
 * @date 2021/4/14 11:14
 */
@Data
@TableName("student")
public class Student implements Serializable {
    @TableId(value = "student_id",type = IdType.AUTO)
    private String id;
    @TableField("name")
    private String name;
    @TableField("class_code")
    private String classCode;
    @TableField(value = "age")
    private String age;
}
