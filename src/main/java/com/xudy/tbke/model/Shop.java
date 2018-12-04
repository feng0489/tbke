package com.xudy.tbke.model;


public class Shop {


    Integer id;
    float totalPrice; //商品价格
    float freePrice; //商品优惠金额
    float price; //实际价格
    float commissionRate;//佣金比率(%)
    Integer couponTotalCount;//优惠券总量
    float couponInfo;//优惠券面额
    Integer couponRemainCount;//优惠券剩余量
    String couponClickUrl;//商品跳转地址
    String photoUrl;//图片地址
    String shopTitle;//店铺名称
    String shopNick;//店铺昵称
    String itemDescription;//宝贝描述(推荐理由)
    String shopId;//店铺id
    String title;//商户品标题
    String shopFrom;//商品所在的平台
    String freeStartTime;//优惠开始时间
    String freeEndTime;//优惠结束时间
    Integer goodsSum;//商品数量
    Integer shopType;//商店类型:0表示集市，1表示商城
    Integer retStatus;//优惠卷状态
    String itemId;//itemid 保留字段
    String lensId;//lensId 保留字段
    String couponKey;//couponKey 保留字段
    Integer count;//统计

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getFreePrice() {
        return freePrice;
    }

    public void setFreePrice(float freePrice) {
        this.freePrice = freePrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getCouponTotalCount() {
        return couponTotalCount;
    }

    public void setCouponTotalCount(Integer couponTotalCount) {
        this.couponTotalCount = couponTotalCount;
    }

    public float getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(float couponInfo) {
        this.couponInfo = couponInfo;
    }

    public Integer getCouponRemainCount() {
        return couponRemainCount;
    }

    public void setCouponRemainCount(Integer couponRemainCount) {
        this.couponRemainCount = couponRemainCount;
    }

    public String getCouponClickUrl() {
        return couponClickUrl;
    }

    public void setCouponClickUrl(String couponClickUrl) {
        this.couponClickUrl = couponClickUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getShopNick() {
        return shopNick;
    }

    public void setShopNick(String shopNick) {
        this.shopNick = shopNick;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShopFrom() {
        return shopFrom;
    }

    public void setShopFrom(String shopFrom) {
        this.shopFrom = shopFrom;
    }

    public String getFreeStartTime() {
        return freeStartTime;
    }

    public void setFreeStartTime(String freeStartTime) {
        this.freeStartTime = freeStartTime;
    }

    public String getFreeEndTime() {
        return freeEndTime;
    }

    public void setFreeEndTime(String freeEndTime) {
        this.freeEndTime = freeEndTime;
    }

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getRetStatus() {
        return retStatus;
    }

    public void setRetStatus(Integer retStatus) {
        this.retStatus = retStatus;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getLensId() {
        return lensId;
    }

    public void setLensId(String lensId) {
        this.lensId = lensId;
    }

    public String getCouponKey() {
        return couponKey;
    }

    public void setCouponKey(String couponKey) {
        this.couponKey = couponKey;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
