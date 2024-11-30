package com.diegomzalez.products_service.dtos;

import java.math.BigDecimal;

public record FinalProductData(String id, String name, String description, BigDecimal price) {

}
