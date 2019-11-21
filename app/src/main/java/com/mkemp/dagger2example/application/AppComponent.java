package com.mkemp.dagger2example.application;

import com.mkemp.dagger2example.application.driver.Driver;
import com.mkemp.dagger2example.application.driver.DriverModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {
    
    // Provides access to get a Driver.
    // Creation is done within the module.
    Driver getDriver();
}
