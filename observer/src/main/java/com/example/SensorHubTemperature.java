package com.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SensorHubTemperature implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Sensor sensor = (Sensor) evt.getSource();
        System.out.println("Sensor Details: " +
                "\nName: " + sensor.getName() +
                "\nPosition: " + sensor.getPosition() +
                "\nTemperature: " + sensor.getTemperature() +
                "\nProperty Changed: " + evt.getPropertyName() +
                "\nOld Value: " + evt.getOldValue() +
                "\nNew Value: " + evt.getNewValue());
    }

}
