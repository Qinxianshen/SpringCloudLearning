package com.qin.eureka_order.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* author:Qinzijing
*  date: 2020/2/4
*  description:商品服务客户端
*/
@FeignClient(name="product-service")
public interface BookProductClient {

    @GetMapping("/api/v1.0/book/findById")
    String findById(@RequestParam(value = "id") Integer id);

}
