package com.order.service;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.order.feign.StorageFeignClient;
import com.order.model.Order;
import com.order.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author xiaojw
 * @describe service
 * @date 2021/3/23 17:34
 */
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private StorageFeignClient storageFeignClient;

    /**
     * 下单：创建订单、减库存，涉及到两个服务
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order()
                .setUserId(userId)
                .setCommodityCode(commodityCode)
                .setCount(count)
                .setMoney(orderMoney);
        orderDAO.insert(order);
        storageFeignClient.deduct(commodityCode, count);

    }
}
