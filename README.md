# RaspberryPi-base-on-IOT
use RaspberryPi to build interesting things.

本项目分两部分：
第一版架构图/architecture/architecture.png

一、cloud

1. use NATAPP 内网穿透
* 用国内的平台，主要是不花钱。
2. UI(javascript ajax) (done)
* 这里先用原生的js开发，毕竟UI不是本项目主要关注的。
3. springboot(java)  (done)
* 使用springboot集成mongoDB进行开发，主要功能是实现web显示和订阅mqtt数据，储存数据。
4. mongoDB (done)
* 这里用mongo作为数据库。
5. MQTT Broker(mosquitto) (done)
* 使用轻量级mqtt broker，简单可靠。


二、edge

1. RaspberryPi 3B
* 用公司的板子，主要也是不花钱。
2. sensors(python)
* 先用公司的DHT11传感器，做温湿度数据采集。
