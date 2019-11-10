package com.mkemp.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
   
    private Engine engine;
    private Wheels wheels;
    
    // Constructor injection
    // Dagger will know how to create this object for us,
    // as long as Engine and Wheels also have constructor injection.
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
    
    void drive() {
        Log.d(TAG, "Driving...");
    }
}
