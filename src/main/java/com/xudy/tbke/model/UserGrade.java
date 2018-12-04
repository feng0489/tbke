package com.xudy.tbke.model;

public class UserGrade {
    //主键id
    private int id;
    //标题
    private String title;
    //年化益率
    private int roe;
    //提现手续费
    private float cash_po;
    //优惠卷
    private float free_price;


    public UserGrade(){
        super();
    }

    public float getFree_price() {
        return free_price;
    }

    public void setFree_price(float free_price) {
        this.free_price = free_price;
    }

    public int getRoe() {
        return roe;
    }

    public void setRoe(int roe) {
        this.roe = roe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCash_po() {
        return cash_po;
    }

    public void setCash_po(float cash_po) {
        this.cash_po = cash_po;
    }
}
