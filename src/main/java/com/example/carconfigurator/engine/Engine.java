package com.example.carconfigurator.engine;

public interface Engine {
    EEngineType getType();
    String getName();
    int getHorsepower();
    String getTransmission();
    int getCC();
}
