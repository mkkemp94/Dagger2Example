package com.mkemp.dagger2example;

import android.util.Log;

import javax.inject.Inject;

// This is one possible implementation of Engine.
public class PetrolEngine implements Engine {
    
    private static final String TAG = "Car";
    
    @Inject
    public PetrolEngine() {
    
    }
    
    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started");
    }
}
