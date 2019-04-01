package com.example.gooddeed;
public class CreateUser {
    // fields
    private int userId;
    private String userName;
    // constructors
    public CreateUser() {}
    public CreateUser(int id, String userName) {
        this.userId = id;
        this.userName = userName;
    }
    // properties
    public void setUserId(int id) {
        this.userId = id;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
}
