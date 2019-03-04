# RaspberryPi-base-on-IOT
use RaspberryPi to build interesting things.

本项目分两部分：
第一版架构图/architecture/architecture.png

一、cloud(springboot)

1. use NATAPP 内网穿透
* 用内网穿透公司网络，在树莓派上跑。
2. UI(javascript ajax)
* 这里先用原生的js开发，毕竟UI不是本项目主要关注的。
3. springboot(java)
* 使用springboot集成MQTT模块，主要功能是实现web显示来自底层传感器返回的mqtt数据，并储存数据。
4. mongoDB
* 这里用docker mongo作为数据库。
5. MQTT Broker(mosquitto)
* 使用轻量级mqtt broker。


二、edge

1. RaspberryPi 3B
* 树莓派跑在公司网络里。
2. sensors(python)
* 若干种类的传感器，通过python code进行驱动, 使用crontab实现定时任务， 通过MQTT实时上传sensor数据，最终在web端显示。


现在所有部分最小demo已完成，进入下一个阶段。
