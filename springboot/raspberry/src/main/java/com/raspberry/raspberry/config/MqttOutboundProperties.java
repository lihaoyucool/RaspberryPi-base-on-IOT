package com.raspberry.raspberry.config;

public class MqttOutboundProperties {
    private String urls;
    private String username;
    private String password;
    private String clientId;
    private String topic;
    private int completionTimeout;
    
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
    public int getCompletionTimeout() {
        return completionTimeout;
    }
    
    public void setUrls(String urls) {
        this.urls = urls;
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
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public void setCompletionTimeout(int completionTimeout) {
        this.completionTimeout = completionTimeout;
    }
}
