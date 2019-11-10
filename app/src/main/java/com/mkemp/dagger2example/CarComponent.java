package com.mkemp.dagger2example;

import dagger.Component;

/**
 * BACKBONE / INJECTOR
 * The component is the most important piece of Dagger.
 * This is where classes get objects from.
 *
 * At compile time Dagger will implement this interface
 * and create all the necessary code.
 */
@Component
public interface CarComponent {
    
    // Constructor Injection:
    // Dagger can make a Car because its constructor is annotated with @Inject.
    // A Car needs Engine and Wheels passed to its constructor.
    // Annotate Engine and Wheels with @Inject too.
    // Dagger can now generate everything.
    Car getCar();
    
}
