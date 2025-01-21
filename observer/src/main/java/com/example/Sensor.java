package com.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Sensor implements Measure {

    private int temperature;
    private String position;
    private String name;
    private PropertyChangeSupport propertyChangeSupport;

    public Sensor() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Sensor(int temperature, String position, String name) {
        this.temperature = temperature;
        this.position = position;
        this.name = name;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.propertyChangeSupport.firePropertyChange("temperature", this.temperature, temperature);
        this.temperature = temperature;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.propertyChangeSupport.firePropertyChange("position", this.position, position);
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.propertyChangeSupport.firePropertyChange("name", this.name, name);
        this.name = name;
    }

    @Override
    public void measure() {
        Random random = new Random();
        setTemperature(random.nextInt(45));
    }
}
