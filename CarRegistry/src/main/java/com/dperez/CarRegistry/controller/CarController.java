package com.dperez.CarRegistry.controller;

import com.dperez.CarRegistry.controller.dtos.CarDTO;
import com.dperez.CarRegistry.model.Car;
import com.dperez.CarRegistry.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController // Indica qeu es un controlador de Spring MVC
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/get-car/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id){
        CarDTO carDTO = new CarDTO(id, "Skoda");
       return ResponseEntity.ok(carDTO);
    }

    @PostMapping("/add-car")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){

        System.out.println("New car added successfully. Id: " + carDTO.getId());

        return ResponseEntity.ok("New car added successfully. Id: " + carDTO.getId());
    }

    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id){

        System.out.println("The car Id to delete is: " + id);
        return ResponseEntity.ok("The car with Id " + id + " has been removed.");
    }


    @PutMapping("/update-car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Integer id, @RequestBody CarDTO carDTO){

        System.out.println("New car added successfully. Id: " + carDTO.getId());

        return ResponseEntity.ok("The car with Id "+ id + " has been updated successfully." );
    }

//    @GetMapping("/cars")
//    public List<Car> getAllCars() {
//
//        // Se informa al usuario de que ha accedido a la aplicación
//        log.info("Acceso al registro de coches: /cars");
//
//        // Se muestra en el log el valor de la propertie defaultBrand desde el método getDefaultBrand de CarService.
//        carService.getDefaultBrand();
//        return carService.getAllCars();
//    }

//    @GetMapping("/cars/by_brand")
//    public ResponseEntity<?> getCarsByBrand(String brand) {
//
//        log.info("Acceso a la aplicación: /cars/by_brand?brand={}", brand);
//
//        // Muestra el resultado de la búsqueda, si no hay ningún resultado muestra mensaje en el navegador.
//        List<Car> listByBrand = carService.getCarsByBrand(brand);
//
//        return  listByBrand.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no "+brand+" car.") :
//                ResponseEntity.ok(listByBrand);
//    }
}
