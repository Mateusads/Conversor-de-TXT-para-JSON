package br.com.converter.json.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Builder
public class Order {

    private final int id;
    private final LocalDate date;
    private double amount;
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
        addAmount(product.getValue());
    }

    private void addAmount(double value){
        this.amount += value;
    }
}
