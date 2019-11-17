package com.mkemp.dagger2example.di;

import com.mkemp.dagger2example.Car;
import com.mkemp.dagger2example.MainActivity;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

/**
 * BACKBONE / INJECTOR
 * The component is the most important piece of Dagger.
 * This is what generates objects that other classes can use.
 * At compile time Dagger will implement this interface and create all the necessary code.
 */
@Component (modules = {
        // Whenever Dagger needs Wheels, Rims, or Tires,
        // it can get them from this Wheels module.
        WheelsModule.class,
        
        // Whenever Dagger need to create an Engine, which is now an interface,
        // it can look at its modules for how to create the engine.
        // The Engine can be either Diesel or Petrol.
        // We can swap which to use here, but can't use both or Dagger won't know which to use.
        // Possible expansions for testing could include a fake EngineModule or WheelsModule
        PetrolEngineModule.class
})
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
    
    // Define the API for our CarComponent ourselves.
    @Component.Builder
    interface Builder {
        
        @BindsInstance // bind instance to type
        Builder horsePower(@Named("horse power") int horsePower);
    
        @BindsInstance // use @Named to allow for more instances of the same type
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);
        
        CarComponent build();
    }
}
