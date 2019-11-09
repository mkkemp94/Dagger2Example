package com.mkemp.dagger2example;

public class Car {
    Engine engine;
    Wheels wheels;
    
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
    
    void drive() {
        // Vroom...
    }
}
