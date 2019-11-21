package com.mkemp.dagger2example;

import android.os.Bundle;

import com.mkemp.dagger2example.application.ExampleApp;
import com.mkemp.dagger2example.di.ActivityComponent;
import com.mkemp.dagger2example.di.DaggerActivityComponent;
import com.mkemp.dagger2example.di.car.Car;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    // This is allowed when MainActivity is injected
    // (Dagger does this 2nd)
    @Inject Car fieldInjectedCar1, fieldInjectedCar2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        ActivityComponent component = DaggerActivityComponent
                .builder()
                .horsePower(150) // the builder we defined only expects horsepower and engine calls
                .engineCapacity(1350) // both must be set here
                
                // Because custom builder, tell the ActivityComponent how to get the AppComponent.
                .appComponent(((ExampleApp) getApplication()).getAppComponent())
                
                .build();
        
        //region Field Injection
        
        // Inject activity so that field and method injection can be executed.
        // Activity must first be injected before field and method injection can be executed.
        // Constructor injection would allow for these to happen automatically,
        // but there is no constructor in android framework classes!
        // See the Car class for constructor injection.
        // (Dagger does this 1st)
        component.inject(this); // Allow for field injection
        fieldInjectedCar1.drive();
        fieldInjectedCar2.drive();
    
        //endregion
        //region Provides
        
        // Get a new car through provision method.
        // This seems to be the simplest way to use Dagger,
        // but it gets less efficient as the project gets bigger.
        Car provisionCar = component.getNewCar();
        provisionCar.drive();
        
        //endregion
        
    }
    
    // (If there were any methods to be injected, Dagger would do this 3rd)
    // (Usually you don't do method injection in activities)
    
}
