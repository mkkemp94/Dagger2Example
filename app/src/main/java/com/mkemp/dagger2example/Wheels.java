package com.mkemp.dagger2example;

public class Wheels {
    
    private Rims rims;
    private Tires tires;
    
    // We don't own this class so we can't annotate it with @Inject
    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
