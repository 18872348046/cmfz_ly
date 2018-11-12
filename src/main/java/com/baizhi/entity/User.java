package com.baizhi.entity;

import java.util.Date;

public class User {
    private String id;
    private String telephone;
    private String username;
    private String password;
    private String salt;
    private String province;
    private String city;
    private String nickName;
    private String headPic;
    private String sex;
    private String sign;
    private Date date;
    private String state;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", sex='" + sex + '\'' +
                ", sign='" + sign + '\'' +
                ", date=" + date +
                ", state='" + state + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User(String id, String telephone, String username, String password, String salt, String province, String city, String nickName, String headPic, String sex, String sign, Date date, String state) {
        this.id = id;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.province = province;
        this.city = city;
        this.nickName = nickName;
        this.headPic = headPic;
        this.sex = sex;
        this.sign = sign;
        this.date = date;
        this.state = state;
    }

    public User() {
    }
}
