package com.mkemp.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
   
    private Engine engine;
    private Wheels wheels;
    
    // Dagger will create this object for us.
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
    
    void drive() {
        Log.d(TAG, "Driving...");
    }
}
