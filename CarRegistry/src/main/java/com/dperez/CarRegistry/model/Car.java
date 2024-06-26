package com.dperez.CarRegistry.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private String brand;
    private String model;
    private Integer year;
}
