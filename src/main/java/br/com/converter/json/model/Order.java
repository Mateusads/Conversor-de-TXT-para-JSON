package br.com.converter.json.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class Order {

    private int id;
    private LocalDate date;
    private double amount;
    private final List<Product> productList = new ArrayList<>();;

    public void addProduct(Product product) {
        this.productList.add(product);
        addAmount(product.getValue());
    }

    public void addAmount(double value){
        this.amount += value;
    }
}
