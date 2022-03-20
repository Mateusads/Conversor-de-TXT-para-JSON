package br.com.converter.json.service;

import br.com.converter.json.model.Product;

public class CreateProduct {

    public Product create(int productId, double productValue) {
        return Product.builder()
                .id(productId)
                .value(productValue)
                .build();
    }
}
