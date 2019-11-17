package com.mkemp.dagger2example;

import android.util.Log;

// This is one possible implementation of Engine.
public class DieselEngine implements Engine {
    
    private static final String TAG = "Car";
    
    private int horsePower;
    
    // Can't inject this anymore because we have to pass horsepower at runtime.
    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }
    
    @Override
    public void start() {
        Log.d(TAG, "Diesel engine started. Horsepower: " + horsePower);
    }
}
