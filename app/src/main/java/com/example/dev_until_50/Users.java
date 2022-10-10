package com.example.dev_until_50;

public class Users {

    private String UserId, name,emailid,dp,phone_number;

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Users(){
        phone_number="null";
    }

    public Users(String userId, String name, String emailid) {
        UserId = userId;
        this.name = name;
        this.emailid = emailid;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
