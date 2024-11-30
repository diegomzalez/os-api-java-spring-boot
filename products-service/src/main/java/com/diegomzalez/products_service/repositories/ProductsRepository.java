package com.diegomzalez.products_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.diegomzalez.products_service.models.ProductModel;

public interface ProductsRepository extends MongoRepository<ProductModel, String> {
}
