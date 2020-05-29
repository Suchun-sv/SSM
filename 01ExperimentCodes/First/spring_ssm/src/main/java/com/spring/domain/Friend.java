package com.spring.domain;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Objects;

public class Friend implements Serializable {
    public Friend(){}
    public Friend(String _name,String _birth,String _gender, String _phoneNum, String _wechat, String _QQ, String _address, Integer _user_id){
        birth=_birth;
        gender=_gender;
        name = _name;
        phoneNum = _phoneNum;
        weChat = _wechat;
        user_id = _user_id;
        QQ = _QQ;
        address = _address;
    }
    private int id;
    @Value("None")
    private String name;

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", weChat='" + weChat + '\'' +
                ", user_id=" + user_id +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", QQ='" + QQ + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Value("11111111111")
    private String phoneNum;

    private String weChat;

    private int user_id;

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String birth;

    private String gender;

    private String QQ;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNum, weChat, QQ, address);
    }
}

