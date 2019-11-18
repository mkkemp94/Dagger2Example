package com.mkemp.dagger2example;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
   
    // (Field injection, if here, Dagger would do 2nd)
    // (As long as constructor injection exists, this can be done without any additional steps)
    private Engine engine;
    private Wheels wheels;
    private Driver driver;
    
    // Constructor injection (Dagger does this 1st)
    // One way to teach Dagger how to create objects.
    // Dagger knows how to create this object for us,
    // as long as Engine and Wheels also have constructor injection.
    // Constructor injection allows for automatic field and method injection.
    @Inject
    public Car(Driver driver, Engine engine, Wheels wheels) {
        this.driver = driver;
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
        
        // Note that engine is now an interface,
        // so Car has no idea whether it's getting a Petrol or Diesel engine.
        // We have different log messages in each Engine object, so that will tell us which one we're using.
        // The type of engine to use is defined in the module list of CarComponent.
        engine.start();
        Log.d(TAG, driver + " drives... " + this);
    }
}
