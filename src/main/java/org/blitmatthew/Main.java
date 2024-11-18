package org.blitmatthew;

import org.blitmatthew.service.CarOps;

public class Main {
    public static void main(String[] args) {
        CarOps carOps = new CarOps();

        System.out.println(carOps.getCarCount());
    }
}