/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;

/**
 *
 * @author hp
 */
public class OrderDetail {

    private String productname, date, account, address, code;
    private double price, intomoney;
    private int amount, status, orderid, pid, phone;
    
    /////
    private User user;
    private java.util.List<Items> items;
    /////
    public OrderDetail() {
    }

    public OrderDetail(int orderid, String productname, double price, int amount, double intomoney, int pid, int status, String date, String account) {
        this.productname = productname;
        this.date = date;
        this.price = price;
        this.intomoney = intomoney;
        this.amount = amount;
        this.status = status;
        this.orderid = orderid;
        this.pid = pid;
        this.account = account;
    }
    
    public OrderDetail(int orderid, String productname, double price, int amount, double intomoney, int pid, int status, String date, String account, String address, int phone) {
        this.productname = productname;
        this.date = date;
        this.price = price;
        this.intomoney = intomoney;
        this.amount = amount;
        this.status = status;
        this.orderid = orderid;
        this.pid = pid;
        this.account = account;
        this.address = address;
        this.phone = phone;
    }
    
    public OrderDetail(int orderid, String productname, double price, int amount, double intomoney, int pid, int status, String date, String account, String address, int phone, String code) {
        this.productname = productname;
        this.date = date;
        this.price = price;
        this.intomoney = intomoney;
        this.amount = amount;
        this.status = status;
        this.orderid = orderid;
        this.pid = pid;
        this.account = account;
        this.address = address;
        this.phone = phone;
        this.code = code;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIntomoney() {
        return intomoney;
    }

    public void setIntomoney(double intomoney) {
        this.intomoney = intomoney;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return account + " " +orderid+" " + productname;
    }

}
