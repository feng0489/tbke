package com.xudy.tbke.model;

public class TradeLog {
    //主键id
    private Integer id;
    //交易订单号
    private String tradOrder;
    //用户ID
    private int userId;
    //用户姓名
    private String username;
    //原有金额
    private float oldPrice;
    //交易金额
    private float tradePrice;
    //手续费
    private float poPrice;
    //备注
    private String remark;
    //交易说明
    private String title;
    //交易时间
    private int tradeTime;
    //设备类型：1 pc , 2 android , 3 ios
    private int dervice;
    //用户交易IP地址
    private String ip;
    //交易状态
    private int status;

    public TradeLog(){
        super();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getDervice() {
        return dervice;
    }

    public void setDervice(int dervice) {
        this.dervice = dervice;
    }

    public int getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(int tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public float getPoPrice() {
        return poPrice;
    }

    public void setPoPrice(float poPrice) {
        this.poPrice = poPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradOrder() {
        return tradOrder;
    }

    public void setTradOrder(String tradOrder) {
        this.tradOrder = tradOrder;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public float getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(float tradePrice) {
        this.tradePrice = tradePrice;
    }
}
