package com.example.carconfigurator.engine;

public class CarImpl implements Car {

    private String name;
    private String color;
    private Engine engine;
    private int wheelsSize;

    public CarImpl(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setWheelsSize(int wheelsSize) {

    }

    @Override
    public int getWheelsSize() {
        return wheelsSize;
    }
}
