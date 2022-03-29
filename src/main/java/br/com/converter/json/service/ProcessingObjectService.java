package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.Product;
import br.com.converter.json.model.User;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class ProcessingObjectService {

    private ExtractDataService extract;

    public User processCreateObject(String line) {

        try {
            var userId = extract.extractUserId(line);
            var userName = extract.extractUserName(line);
            var user = creatingUser(userId, userName);

            var orderId = extract.extractOrderId(line);
            var orderDate = extract.extractOrderDate(line);
            var order = createOrder(orderId, orderDate);

            var productId = extract.extractProductId(line);
            var productValue = extract.extractProductValue(line);
            var product = createProduct(productId, productValue);

            order.addProduct(product);
            user.addOrder(order);
            return user;
        } catch (NumberFormatException e) {
            System.out.println("500 Erro: Non-standard line for conversion");
        }
        return User.builder().build();
    }

    private User creatingUser(int userId, String userName) {
        return User.builder()
                .id(userId)
                .name(userName)
                .build();
    }

    private Order createOrder(int orderId, LocalDate orderDate) {
        return Order.builder()
                .id(orderId)
                .date(orderDate)
                .build();
    }

    private Product createProduct(int productId, Double productValue) {
        return Product.builder()
                .id(productId)
                .value(productValue)
                .build();
    }


}
