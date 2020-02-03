package com.qin.eureka_product.Service;


import com.qin.eureka_product.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Book findById(Integer id);
}
