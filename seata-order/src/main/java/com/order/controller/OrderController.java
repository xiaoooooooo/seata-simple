package com.order.controller;

import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojw
 * @describe OrderController
 * @date 2021/3/23 17:33
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
   private OrderService orderService;

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @RequestMapping("/placeOrder/commit/{product}")
    public Boolean placeOrderCommit(@PathVariable(name = "product",required = false) String product) {
        orderService.placeOrder("1", product, 1);
        return true;
    }
    @Value("${order.appName}")
    private String appName;

    @RequestMapping("/order/nacosConfig")
    public String nacosConfig() {
        return appName;
    }

    @RequestMapping("/order/hello")
    public String hello() {
        return "this is a order response";
    }
}
