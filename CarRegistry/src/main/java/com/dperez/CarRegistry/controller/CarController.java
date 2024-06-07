package com.dperez.CarRegistry.controller;

import com.dperez.CarRegistry.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CarController {

    @GetMapping("/cars")
    List<Car> getCarData();

    @GetMapping("/cars/by_brand")
    ResponseEntity<?> getCarsByBrand(@RequestParam String brand);
}
