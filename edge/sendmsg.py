#!/usr/bin/python
#-*-coding:utf-8-*-
# import paho.mqtt.client as mqtt
import paho.mqtt.publish as publish
import time

HOST = "127.0.0.1"
PORT = 1883
# def on_connect(client, userdata, flags, rc):
#     print("Connected with result code "+str(rc))
#     client.subscribe("test")

# def on_message(client, userdata, msg):
#     print(msg.topic+" "+msg.payload.decode("utf-8"))
if __name__ == '__main__':
    client_id = time.strftime('%Y%m%d%H%M%S',time.localtime(time.time()))
    # client = mqtt.Client(client_id)
    # client.username_pw_set("admin", "123456")
    # client.on_connect = on_connect
    # client.on_message = on_message
    # client.connect(HOST, PORT, 60)
    # client.publish("test", "你好 MQTT", qos=0, retain=False)
    publish.single("Raspberry", "123", qos = 1,hostname=HOST,port=PORT, client_id=client_id,auth = {'username':"admin", 'password':"123456"})