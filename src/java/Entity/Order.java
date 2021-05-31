/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author hp
 */
public class Order {
    private int orderid;
    private double totalmoney;

    public Order() {
    }

    public Order(int orderid, double totalmoney) {
        this.orderid = orderid;
        this.totalmoney = totalmoney;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }
    
}
