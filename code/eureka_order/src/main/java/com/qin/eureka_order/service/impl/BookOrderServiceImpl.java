package com.qin.eureka_order.service.impl;


import com.qin.eureka_order.domain.BookOrder;
import com.qin.eureka_order.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

/* author:Qinzijing
*  date: 2020/2/3
*  description:
*/

@Service
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public BookOrder save(Integer userId, Integer bookId) {

        /*  使用 ribbon 调用 注册中心里的 商品服务 */
        Object object = restTemplate.getForObject("http://product-service/api/v1.0/book/findById?id="+bookId,Object.class);
        System.out.println(object);


        BookOrder bookOrder = new BookOrder();
        bookOrder.setCreateDate(new Date());
        bookOrder.setUserId(userId);
        bookOrder.setId(UUID.randomUUID().toString());



        return bookOrder;
    }
}
