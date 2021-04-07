package com.example.books.pojo;



import java.util.Objects;

public class TbUser {

    private long userId;
    private String username;
    private String password;
    private long userNumber;
    private String classname;

    public TbUser() {
    }

    public TbUser(String username, String password, long userNumber, String classname) {
        this.username = username;
        this.password = password;
        this.userNumber = userNumber;
        this.classname = classname;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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


    public long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(long userNumber) {
        this.userNumber = userNumber;
    }


    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TbUser)) return false;
        TbUser tbUser = (TbUser) o;
        return getUserId() == tbUser.getUserId() &&
                getUserNumber() == tbUser.getUserNumber() &&
                Objects.equals(getUsername(), tbUser.getUsername()) &&
                Objects.equals(getPassword(), tbUser.getPassword()) &&
                Objects.equals(getClassname(), tbUser.getClassname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getPassword(), getUserNumber(), getClassname());
    }

    @Override
    public String toString() {
        return "TbUsers{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_number=" + userNumber +
                ", classname='" + classname + '\'' +
                '}';
    }

}
