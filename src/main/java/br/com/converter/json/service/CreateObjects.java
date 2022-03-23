package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.Product;
import br.com.converter.json.model.User;

import java.time.LocalDate;

public class CreateObjects {

    public User creatingUser(int userId, String userName) throws NullPointerException {
        return User.builder()
                .id(userId)
                .name(userName)
                .build();
    }

    public Order createOrder(int orderId, LocalDate orderDate) throws NullPointerException {
        return Order.builder()
                .id(orderId)
                .date(orderDate)
                .build();
    }

    public Product createProduct(int productId, Double productValue) throws NullPointerException {
        return Product.builder()
                .id(productId)
                .value(productValue)
                .build();
    }
}
