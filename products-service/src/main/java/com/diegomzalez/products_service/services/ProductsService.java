package com.diegomzalez.products_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diegomzalez.products_service.dtos.BaseProductData;
import com.diegomzalez.products_service.dtos.FinalProductData;
import com.diegomzalez.products_service.models.ProductModel;
import com.diegomzalez.products_service.repositories.ProductsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public void storeOneProduct(BaseProductData baseProductData) {
        this.productsRepository.save(ProductModel.builder().name(baseProductData.name())
                .description(baseProductData.description()).price(baseProductData.price()).build());
    }

    public List<FinalProductData> findAllProducts() {
        return this.productsRepository.findAll().stream().map(product -> new FinalProductData(product.getId(),
                product.getName(), product.getDescription(), product.getPrice())).toList();
    }
}
