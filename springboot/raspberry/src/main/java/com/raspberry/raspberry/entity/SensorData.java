package com.raspberry.raspberry.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SensorData implements Serializable{
    private String id;
    private String number;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
