package com.raspberry.raspberry.config;

import lombok.Data;

@Data
public class MqttInboundProperties {
    private String url;
    private String username;
    private String password;
    private String clientId;
    private String topics;
    private int completionTimeout;
    
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
    public int getCompletionTimeout() {
        return completionTimeout;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public void setTopics(String topics) {
        this.topics = topics;
    }
    public void setCompletionTimeout(int completionTimeout) {
        this.completionTimeout = completionTimeout;
    }
}
