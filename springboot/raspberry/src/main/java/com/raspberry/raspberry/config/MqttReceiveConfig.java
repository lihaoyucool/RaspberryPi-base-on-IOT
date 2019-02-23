package com.raspberry.raspberry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {
    
    @Autowired MqttProperties mqttConfig;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs(mqttConfig.getOutbound().getUrls());
        factory.setConnectionTimeout(mqttConfig.getOutbound().getCompletionTimeout());
        factory.setUserName(mqttConfig.getOutbound().getUsername());
        factory.setPassword(mqttConfig.getOutbound().getPassword());
        factory.setKeepAliveInterval(3);
        return factory;
    }
 
    /***接收通道***/
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }
    
    /***配置client,监听的topic***/
    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getOutbound().getClientId(), mqttClientFactory(), 
                        mqttConfig.getOutbound().getTopic(), "default_topic");
        adapter.setCompletionTimeout(mqttConfig.getOutbound().getCompletionTimeout());
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }
    
    /***通过通道获取数据,并进行处理***/
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                //GenericMessage [payload=123, headers={mqtt_retained=false, mqtt_qos=0, id=719d77bc-8008-7734-db98-2a9179a7300b, 
                //mqtt_topic=hello, mqtt_duplicate=false, timestamp=1550849737454}]
                String topic = message.getHeaders().get("mqtt_topic").toString();
                if("Raspberry".equalsIgnoreCase(topic)){
                    System.out.println("Raspberry,fuckXX,"+message.getPayload().toString());
                }else if("default_topic".equalsIgnoreCase(topic)){
                    System.out.println("default_topic,fuckXX,"+message.getPayload().toString());
                }
            }
        };
    }
}
