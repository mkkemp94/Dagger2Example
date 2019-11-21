package com.mkemp.dagger2example.application.driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DriverModule {
    
    // This says how to create a driver.
    // Only one Driver per application.
    @Provides
    @Singleton
    Driver provideDriver() {
        return new Driver();
    }
}
