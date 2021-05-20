package com.storage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaojw
 * @describe AdviceController
 * @date 2021/5/20 10:38
 */
@ControllerAdvice
@Slf4j
public class AdviceController {

    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public String exceptionHandle(Throwable throwable){
        if(throwable instanceof ClassNotFoundException){
            log.error(throwable.getMessage());
            return "类不存在";
        }else if(throwable instanceof IndexOutOfBoundsException){
            log.error(throwable.getMessage());
            return "数组越界";
        }
        return "服务器内部错误";
    }
}
