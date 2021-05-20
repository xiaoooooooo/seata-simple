package com.storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojw
 * @describe DemoController
 * @date 2021/3/29 11:17
 */
@RestController
@RequestMapping("api/demo")
public class DemoController {

    @GetMapping("/hello")
    public String simpleOrder(){
        return "this is a consumer response";
    }
}
