package com.qin.eureka_product.Service.Impl;


import com.qin.eureka_product.Service.BookService;
import com.qin.eureka_product.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    /*
    *
    * 数据层暂时忽略 不写 只是做一个demo
    * */

    @Override
    public Book findById(Integer id) {
        Book book = new Book(1,"java 实战",20);
        return book;
    }
}
