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
public class newPro extends Product{
    private int soluong;
    public newPro() {
    }
    

    public newPro( int pid, String pname, double price, int amount, String img, int cid, String description, int soluong) {
        super(pid, pname, price, amount, img, cid, description);
        this.soluong = soluong;
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription() {
        return super.getDescription(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPrice() {
        return super.getPrice(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setImg(String img) {
        super.setImg(img); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getImg() {
        return super.getImg(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPname(String pname) {
        super.setPname(pname); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPname() {
        return super.getPname(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCid(int cid) {
        super.setCid(cid); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCid() {
        return super.getCid(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAmount(int amount) {
        super.setAmount(amount); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAmount() {
        return super.getAmount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPid(int pid) {
        super.setPid(pid); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPid() {
        return super.getPid(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
