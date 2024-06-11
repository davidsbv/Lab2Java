package com.dperez.CarRegistry.controller;

import com.dperez.CarRegistry.model.Car;
import com.dperez.CarRegistry.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController // Indica qeu es un controlador de Spring MVC
public class CarController {

    @Autowired
    private CarService carService;

//    @Autowired
//    private CarRepository carRepository;


    @GetMapping("/cars")
    public List<Car> getAllCars() {

        // Se informa al usuario de que ha accedido a la aplicación
        log.info("Acceso al registro de coches: /cars");

        // Se muestra en el log el valor de la propertie defaultBrand desde el método getDefaultBrand de CarService.
        carService.getDefaultBrand();
        return carService.getAllCars();
    }

    @GetMapping("/cars/by_brand")
    public ResponseEntity<?> getCarsByBrand(String brand) {

        log.info("Acceso a la aplicación: /cars/by_brand?brand={}", brand);

        // Muestra el resultado de la búsqueda, si no hay ningún resultado muestra mensaje en el navegador.
        List<Car> listByBrand = carService.getCarsByBrand(brand);

        return  listByBrand.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no "+brand+" car.") :
                ResponseEntity.ok(listByBrand);
    }
}
