package com.mkemp.dagger2example.di.car;

import android.util.Log;

import javax.inject.Inject;

class Remote {
    
    private static final String TAG = "Remote";
    
    @Inject
    public Remote() {
        
    }
    
    public void setListener(Car car) {
        Log.d(TAG, "Remote connected to Car");
    }
}
