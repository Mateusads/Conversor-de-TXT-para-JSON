package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.User;

import java.time.LocalDate;

public class CreateOrder {

    public Order create(int id, LocalDate date) {
        return Order.builder()
                .id(id)
                .date(date)
                .build();
    }
}
