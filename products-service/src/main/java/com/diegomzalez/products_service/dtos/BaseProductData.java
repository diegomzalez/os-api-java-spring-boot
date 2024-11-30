package com.diegomzalez.products_service.dtos;

import java.math.BigDecimal;

public record BaseProductData(String name, String description, BigDecimal price) {

}
