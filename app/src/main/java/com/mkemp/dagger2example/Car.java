package com.mkemp.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
   
    // (Field injection, if here, Dagger would do 2nd)
    // (As long as constructor injection exists, this can be done without any additional steps)
    private Engine engine;
    private Wheels wheels;
    
    // Constructor injection (Dagger does this 1st)
    // Dagger knows how to create this object for us,
    // as long as Engine and Wheels also have constructor injection.
    // Constructor injection allows for automatic field and method injection.
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
    
    // Method injection (Dagger does this 3rd)
    // Use method injection if you have to pass the injected object itself (Car) to the dependency (Remote).
    // This will be automatically executed after the constructor finishes.
    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }
    
    void drive() {
        Log.d(TAG, "Driving...");
    }
}
