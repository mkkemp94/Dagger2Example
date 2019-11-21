package com.mkemp.dagger2example.application;

import android.app.Application;

public class ExampleApp extends Application {
    
    private AppComponent mComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mComponent = DaggerAppComponent.create();
    }
    
    public AppComponent getAppComponent() {
        return mComponent;
    }
}
