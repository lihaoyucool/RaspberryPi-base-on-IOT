package com.raspberry.raspberry.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SensorData implements Serializable{
    
    private String id;
    private String number;
    private String status;
    
  
    public void setId(String id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getId() {
        return id;
    }
    public String getNumber() {
        return number;
    }
    public String getStatus() {
        return status;
    }
}
