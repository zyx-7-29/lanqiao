package org.taru.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class   Order {
    private String orderId;

    private String orderUserId;

   private Date orderDateTime;

    private Byte orderIsSend;

    private Byte orderIsValid;

    private BigDecimal orderTotalPrice;

    private Byte orderStatus;

    private String orderComment;

    private User    user;

    public List<User> getUser2() {
        return user2;
    }

    public void setUser2(List<User> user2) {
        this.user2 = user2;
    }

    private List<User> user2;

    public void setUser(User user){
        this.user=user;
    }
    public User  getUser(){
        return this.user;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId == null ? null : orderUserId.trim();
    }

//    public String getOrderDateTime() {
//        return DateUtils.toString(orderDateTime);
//    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Byte getOrderIsSend() {
        return orderIsSend;
    }

    public void setOrderIsSend(Byte orderIsSend) {
        this.orderIsSend = orderIsSend;
    }

    public Byte getOrderIsValid() {
        return orderIsValid;
    }

    public void setOrderIsValid(Byte orderIsValid) {
        this.orderIsValid = orderIsValid;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }
}