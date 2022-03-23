package br.com.converter.json.service;


import br.com.converter.json.model.Product;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateProductTest{

    @Test
    public void testCreatingOrderForBuilder() {
        var product = Product.builder()
                .id(1)
                .value(101.20)
                .build();

        assertThat(product.getId()).isEqualTo(1);
        assertThat(product.getValue()).isEqualTo(101.20);
    }
}