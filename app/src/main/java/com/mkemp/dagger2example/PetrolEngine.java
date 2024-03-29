package com.mkemp.dagger2example;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

// This is one possible implementation of Engine.
public class PetrolEngine implements Engine {
    
    private static final String TAG = "Car";
    private int horsePower;
    private int engineCapacity;
    
    @Inject // name these instances so the Component can use them
    public PetrolEngine(@Named("horse power") int horsePower,
                        @Named("engine capacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }
    
    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started. " +
                "\nHorsepower: " + horsePower +
                "\nEngine Capacity: " + engineCapacity);
    }
}
