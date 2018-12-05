package com.xudy.tbke.model;

public class UserGrade {
    //主键id
    private Integer id;
    //标题
    private String title;
    //年化益率
    private int roe;
    //提现手续费
    private float cashPo;
    //优惠卷
    private float freePrice;


    public UserGrade(){
        super();
    }

    public float getFree_price() {
        return freePrice;
    }

    public void setFree_price(float freePrice) {
        this.freePrice = freePrice;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getCash_po() {
        return cashPo;
    }

    public void setCash_po(float cashPo) {
        this.cashPo = cashPo;
    }
}
