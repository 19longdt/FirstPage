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
public class Items {
    private int id;
    private Product product;
    private int amount;
    private double intomoney;

    public Items() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getIntomoney() {
        return intomoney;
    }

    public void setIntomoney(double intomoney) {
        this.intomoney = intomoney;
    }
    
}
