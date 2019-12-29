package com.zhc.controller;

import com.zhc.domain.User;

import java.util.List;

public class Users {
    private List<User> userList;

    public List<User> getUserList(){
        return userList;
    }

    public void setUserList(List<User> userList){
        this.userList=userList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + userList +
                '}';
    }
}
