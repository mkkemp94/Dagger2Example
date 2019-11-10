package com.mkemp.dagger2example;

import android.util.Log;

public class Tires {
    private static final String TAG = "Tires";
    
    // We don't own this class so we can't annotate it with @Inject
    
    public void inflate() {
        Log.d(TAG, "Tires inflated");
    }
}
