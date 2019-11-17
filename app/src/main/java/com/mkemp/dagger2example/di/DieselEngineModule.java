package com.mkemp.dagger2example.di;

import com.mkemp.dagger2example.DieselEngine;
import com.mkemp.dagger2example.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {
    
    // Can @Provide this but no point doing so with current implementation.
    // The provider for engine can just use this field.
    private int horsePower;
    
    // Pass horsepower to the module at runtime.
    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }
    
    @Provides
    Engine provideEngine() {
        return new DieselEngine(horsePower);
    }
    
}
