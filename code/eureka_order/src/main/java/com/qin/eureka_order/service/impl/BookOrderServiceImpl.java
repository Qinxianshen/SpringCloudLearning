package com.qin.eureka_order.service.impl;


import com.fasterxml.jackson.databind.JsonNode;
import com.qin.eureka_order.domain.BookOrder;
import com.qin.eureka_order.service.BookOrderService;
import com.qin.eureka_order.service.BookProductClient;
import com.qin.eureka_order.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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



    /*    ribbon负载均衡 方法一 */
    @Autowired
    private RestTemplate restTemplate;


    /*    ribbon负载均衡 方法二 */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /*  Feign 远程调用服务 */
    @Autowired
    private BookProductClient bookProductClient;


    @Override
    public BookOrder save(Integer userId, Integer bookId) {

        /*  使用 ribbon 调用 注册中心里的 商品服务 方法一 */
//        Object object = restTemplate.getForObject("http://product-service/api/v1.0/book/findById?id="+bookId,Object.class);
//        System.out.println(object);
//
//
//        BookOrder bookOrder = new BookOrder();
//        bookOrder.setCreateDate(new Date());
//        bookOrder.setUserId(userId);
//        bookOrder.setId(UUID.randomUUID().toString());

        /*  使用 ribbon 调用 注册中心里的 商品服务 方法二 */

//        ServiceInstance instance = loadBalancerClient.choose("product-service");
//        String url = String.format("http://%s:%s/api/v1.0/book/findById?id="+bookId,instance.getHost(),instance.getPort());
//        RestTemplate restTemplate1 = new RestTemplate();
//        Object object = restTemplate1.getForObject(url,Object.class);
//        System.out.println(object);
//        BookOrder bookOrder = new BookOrder();
//        bookOrder.setCreateDate(new Date());
//        bookOrder.setUserId(userId);
//        bookOrder.setId(UUID.randomUUID().toString());

        /*  使用Feign完成远程调用   之前设定的自定义策略仍然有效 */
        String response = bookProductClient.findById(bookId);
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        System.out.println(jsonNode);
        System.out.println(jsonNode.get("name"));

        BookOrder bookOrder = new BookOrder();
        bookOrder.setCreateDate(new Date());
        bookOrder.setUserId(userId);
        bookOrder.setId(UUID.randomUUID().toString());


        return bookOrder;
    }
}
