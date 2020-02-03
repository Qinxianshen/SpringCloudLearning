package com.qin.eureka_order.controller;


import com.qin.eureka_order.domain.BookOrder;
import com.qin.eureka_order.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/bookOrder")
public class BookOrderController {

    @Autowired
    public BookOrderService bookOrderService;

    @GetMapping("/save")
    public BookOrder save(Integer userId,Integer bookId){
        return  bookOrderService.save(userId,bookId);
    }

}
