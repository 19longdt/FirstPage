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
public class OrderforAdmin {
    private int cid, status, amount, pid;
    private String  account, address, phone, date;
    private double total;
    
    public OrderforAdmin() {
    }

    public OrderforAdmin(int cid, double total, String account, String address, String phone, String date, int status) {
        this.cid = cid;
        this.status = status;
        this.account = account;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.total = total;
    }

    public OrderforAdmin(int cid, int amount, int pid) {
        this.cid = cid;
        this.amount = amount;
        this.pid = pid;
    }
     public OrderforAdmin(int cid, int amount, int pid, double total) {
        this.cid = cid;
        this.amount = amount;
        this.pid = pid;
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
