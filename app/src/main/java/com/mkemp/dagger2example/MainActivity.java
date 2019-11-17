package com.mkemp.dagger2example;

import android.os.Bundle;

import com.mkemp.dagger2example.di.CarComponent;
import com.mkemp.dagger2example.di.DaggerCarComponent;
import com.mkemp.dagger2example.di.DieselEngineModule;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    // This is allowed when MainActivity is injected
    // (Dagger does this 2nd)
    @Inject Car fieldInjectedCar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        CarComponent component = DaggerCarComponent.builder()
                // Pass horsepower to module at runtime.
                .dieselEngineModule(new DieselEngineModule(100))
                .build();
        
        //region Field Injection
        
        // Inject activity so that field and method injection can be executed.
        // Activity must first be injected before field and method injection can be executed.
        // Constructor injection would allow for these to happen automatically,
        // but there is no constructor in android framework classes!
        // See the Car class for constructor injection.
        // (Dagger does this 1st)
        component.inject(this); // Allow for field injection
        fieldInjectedCar.drive();
    
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
