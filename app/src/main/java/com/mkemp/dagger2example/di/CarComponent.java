package com.mkemp.dagger2example.di;

import com.mkemp.dagger2example.Car;
import com.mkemp.dagger2example.MainActivity;

import dagger.Component;

/**
 * BACKBONE / INJECTOR
 * The component is the most important piece of Dagger.
 * This is what generates objects that other classes can use.
 * At compile time Dagger will implement this interface and create all the necessary code.
 */
@Component (modules =
        // Whenever Dagger needs Wheels, Rims, or Tires,
        // it can get them from this Wheels module.
        WheelsModule.class
)
public interface CarComponent {
    
    // Provision Method:
    // Dagger can make a Car because its constructor is annotated with @Inject.
    // A Car needs Engine and Wheels passed to its constructor.
    // Annotate Engine and Wheels with @Inject too.
    // Dagger can now generate everything.
    // Call this to get a new car.
    Car getNewCar();
    // ...
    // Car itself could come from a module,
    // but this is not necessary because we have an @Inject-annotated constructor.
    
    // Field Injection:
    // Dagger can inject directly into MainActivity's fields.
    // This can only be done with fields annotated with @Inject.
    // Constructor injection is preferred but we don't create our MainActivity object.
    // Field injection is useful for framework types that the Android system instantiates.
    // Each activity that we want to use needs to be injected separately into the CarComponent.
    void inject(MainActivity mainActivity);
}
