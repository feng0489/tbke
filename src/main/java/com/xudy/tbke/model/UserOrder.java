package com.xudy.tbke.model;

public class UserOrder {
    //主键id
    private Integer id;
    //订单号
    private String order;
    //订单号标题
    private String title;
    //商品图片
    private String image;
    //商品总价格
    private float totalPrice;
    //优惠金额
    private float salePrice;
    //实际价格
    private float price;
    //支付交易号
    private String priceOrder;
    //创建时间
    private String createTime;
    //成交时间
    private String dealTime;
    //商品名称
    private String shopName;
    //商品数量
    private int shopSun;
    //推广链接
    private String varchar;
    //订单状态
    private int orderStatus;
    //分红状态
    private int roeStatus;

    public UserOrder(){
        super();
    }

    public int getRoeStatus() {
        return roeStatus;
    }

    public void setRoeStatus(int roeStatus) {
        this.roeStatus = roeStatus;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getVarchar() {
        return varchar;
    }

    public void setVarchar(String varchar) {
        this.varchar = varchar;
    }

    public int getShopSun() {
        return shopSun;
    }

    public void setShopSun(int shopSun) {
        this.shopSun = shopSun;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(String priceOrder) {
        this.priceOrder = priceOrder;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
