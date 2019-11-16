package com.mkemp.dagger2example.di;

import com.mkemp.dagger2example.Engine;
import com.mkemp.dagger2example.PetrolEngine;

import dagger.Binds;
import dagger.Module;

// Dagger never creates an implementation for this class when it is abstract,
// so you can't use normal @Provides methods in this class when it is abstract.
// Don't make the module abstract if you want to use normal @Provides methods.
// Static @Provides methods are fine though.
@Module
public abstract class PetrolEngineModule {
    
    // This is one way to provide a PetrolEngine.
    // Depends on there being constructor injection for PetrolEngine.
    // If there was no constructor injection for PetrolEngine, we could create a new PetrolEngine inside this method.
//    @Provides
//    Engine provideEngine(PetrolEngine engine) {
//        return engine;
//    }
    
    // This is a cleaner, more optimized way to do it.
    // It requires the class to be abstract.
    // It also depends on there being constructor injection for PetrolEngine.
    // Iif there was no constructor injection for PetrolEngine, this wouldn't work at all.
    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
