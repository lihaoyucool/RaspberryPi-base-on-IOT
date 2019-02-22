package com.raspberry.raspberry.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MqttOutboundProperties {
    private String urls;
    private String username;
    private String password;
    private String clientId;
    private String topic;
    
    public String getUrls() {
        return urls;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getClientId() {
        return clientId;
    }
    public String getTopic() {
        return topic;
    }
}
