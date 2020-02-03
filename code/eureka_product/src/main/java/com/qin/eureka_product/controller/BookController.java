package com.qin.eureka_product.controller;

import com.qin.eureka_product.Service.BookService;
import com.qin.eureka_product.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/book")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/findById")
    public Book findById(Integer id){
        Book book = bookService.findById(id);
        return  book;
    }

}
