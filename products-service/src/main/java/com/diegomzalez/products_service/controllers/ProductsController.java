package com.diegomzalez.products_service.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diegomzalez.products_service.dtos.BaseProductData;
import com.diegomzalez.products_service.dtos.FinalProductData;
import com.diegomzalez.products_service.services.ProductsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@RestController
public class ProductsController {
    private final ProductsService productsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createOneProduct(@RequestBody BaseProductData requestBody) {
        this.productsService.storeOneProduct(requestBody);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<FinalProductData> getAllProducts() {
        return this.productsService.findAllProducts();
    }

}
