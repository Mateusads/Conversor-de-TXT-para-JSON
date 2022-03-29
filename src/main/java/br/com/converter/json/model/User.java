package br.com.converter.json.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    private final int id;
    private final String name;
    private final Set<Order> orders = new HashSet<>();
    private static final Map<Integer, Order> existingOrder = new HashMap<>();

    public void addOrder(Order order) {
        if (existingOrder.containsKey(order.getId())) {
            var orderExistent = existingOrder.get(order.getId());
            for (Product product : order.getProducts()) {
                orderExistent.addProduct(product);
            }
        } else {
            this.orders.add(order);
            existingOrder.put(order.getId(), order);
        }
    }
}
