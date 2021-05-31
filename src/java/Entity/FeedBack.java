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
public class FeedBack {
    private int fid, status;
    private String mail, details, account;

    public FeedBack() {
    }

    public FeedBack(int fid, String details, String mail, int status, String account) {
        this.fid = fid;
        this.status = status;
        this.details = details;
        this.account = account;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
    
}
