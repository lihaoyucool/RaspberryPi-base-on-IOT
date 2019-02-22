package com.raspberry.raspberry.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MqttInboundProperties {
    private String url;
    private String username;
    private String password;
    private String clientId;
    private String topics;
    
    public String getUrl() {
        return url;
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
    public String getTopics() {
        return topics;
    }
}
