package org.blitmatthew.service;

import org.blitmatthew.data.DataRetriever;
import org.blitmatthew.entity.Car;

import java.util.List;

public class CarOps {
    List<Car> cars = DataRetriever.getCars();

    public Integer getCarCount() {
        return cars.size();
    }
}
