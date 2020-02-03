package com.qin.eureka_product.controller;

import com.qin.eureka_product.Service.BookService;
import com.qin.eureka_product.domain.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/book")
public class BookController {

    /* 注解获得配置文件里的数据值 */
    @Value("${server.port}")
    private String port;

    @Autowired
    public BookService bookService;

    @GetMapping("/findById")
    public Book findById(Integer id){
        Book book = bookService.findById(id);

        Book newBook = new Book();

        /* Springboot 提供的复制bean的方法*/
        BeanUtils.copyProperties(book,newBook);
        newBook.setName(newBook.getName()+"data form " + port);
        return  newBook;
    }

}
