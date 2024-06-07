package com.dperez.CarRegistry.repository;

import com.dperez.CarRegistry.model.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();
    List<Car> findByBrand(String brand);
}
