package com.example.carconfigurator.engine;

public interface Car {
    String getName();
    Engine getEngine();
    void setColor(String color);
    String getColor();
    void setWheelsSize(int wheelsSize);
    int getWheelsSize();
}
