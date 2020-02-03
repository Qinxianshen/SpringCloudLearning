package com.qin.eureka_order.domain;


import java.io.Serializable;
import java.util.Date;

/* author:Qinzijing
*  date: 2020/2/3
*  description:订单实体类
*/
public class BookOrder implements Serializable {
    /*  订单号 */
    private  String Id;

    private  Integer userId;
    private  String userName;

    private  Integer bookId;
    private  Integer bookName;
    private  Integer price;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    /* 订单创建时间 */
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookName() {
        return bookName;
    }

    public void setBookName(Integer bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
