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
public class User {

    private String Account, password, name, date, address, question, answer, mail,code;
    private int phone, gender;

    public User(String Account, String password, String name, String date, int gender, String address, String question, String answer, int phone, String mail) {
        this.Account = Account;
        this.password = password;
        this.name = name;
        this.date = date;
        this.address = address;
        this.question = question;
        this.answer = answer;
        this.gender = gender;
        this.phone = phone;
        this.mail = mail;
    }

    public User(String Account, String password, String name, String date, int gender, String address, String question, String answer, int phone, String mail, String code) {
        this.Account = Account;
        this.password = password;
        this.name = name;
        this.date = date;
        this.address = address;
        this.question = question;
        this.answer = answer;
        this.gender = gender;
        this.phone = phone;
        this.mail = mail;
        this.code = code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public User(String name, String mail, String code) {
        this.name = name;
        this.mail = mail;
        this.code = code;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public User() {
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return Account + " " + password;
    }

}
