package com.mkemp.dagger2example;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    @Inject Car fieldInjectedCar; // This is allowed because MainActivity is injected
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        CarComponent component = DaggerCarComponent.create();
        component.inject(this); // Allow for field injection
        fieldInjectedCar.drive();
        
        Car provisionCar = component.getNewCar(); // Get new car through provision method
        provisionCar.drive();
        
    }
}
