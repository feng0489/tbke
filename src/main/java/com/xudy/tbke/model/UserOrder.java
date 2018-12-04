package com.xudy.tbke.model;

public class UserOrder {
    //主键id
    private int id;
    //订单号
    private String order;
    //订单号标题
    private String title;
    //商品图片
    private String image;
    //商品总价格
    private float total_price;
    //优惠金额
    private float sale_price;
    //实际价格
    private float price;
    //支付交易号
    private String price_order;
    //创建时间
    private String createTime;
}
