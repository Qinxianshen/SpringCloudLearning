package com.qin.eureka_order.service;

import com.qin.eureka_order.domain.BookOrder;
import org.springframework.stereotype.Service;

/* author:Qinzijing
*  date: 2020/2/3
*  description:订单的接口
*/
@Service
public interface BookOrderService {

    BookOrder save(Integer userId,Integer bookId);

}
