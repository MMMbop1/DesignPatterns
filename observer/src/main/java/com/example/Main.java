package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SensorHubTemperature hubTemperature = new SensorHubTemperature();
        Sensor sensor = new Sensor(10, "Living Room", "Left side");
        sensor.addPropertyChangeListener(hubTemperature);
        sensor.measure();


        Sensor sensor2 = new Sensor(25, "Master room", "right side");
        sensor2.addPropertyChangeListener(hubTemperature);
        sensor2.measure();
    }

}