package com.mkemp.dagger2example.di;

import com.mkemp.dagger2example.Rims;
import com.mkemp.dagger2example.Tires;
import com.mkemp.dagger2example.Wheels;

import dagger.Module;
import dagger.Provides;

/**
 * This module tells Dagger how to make Wheels, Rims, and Tires,
 * which come from an external source and can't be @Inject-ed through the constructor.
 * This is another way to teach Dagger how to create objects.
 */
@Module // let's Dagger know it can use this class to create Wheels
public class WheelsModule {
    
    @Provides
    static Rims provideRims() {
        // We can't annotate the constructor but we can call the constructor ourselves.
        return new Rims();
    }
    
    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        // We need to do configuration after instantiating this object.
        tires.inflate();
        return tires;
    }
    
    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
