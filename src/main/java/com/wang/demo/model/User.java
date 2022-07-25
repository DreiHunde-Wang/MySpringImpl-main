package com.wang.demo.model;

import java.util.Date;

public class User{
    private Integer id;
    private String username;
    private String password;
    private Date timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
    public Date getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
    	return "id="+id+" , name="+username+" , password="+password;
    }
}