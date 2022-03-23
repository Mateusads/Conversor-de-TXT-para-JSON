package br.com.converter.json.service;

import br.com.converter.json.model.User;

public class ProcessingObject {

    private final ExtractDataService extract = new ExtractDataService();
    private final CreateObjects createObjects = new CreateObjects();

    public User processCreateObject(String line) {

        try {
            var userId = extract.extractUserId(line);
            var userName = extract.extractUserName(line);
            var user = createObjects.creatingUser(userId, userName);

            var orderId = extract.extractOrderId(line);
            var orderDate = extract.extractOrderDate(line);
            var order = createObjects.createOrder(orderId, orderDate);

            var productId = extract.extractProductId(line);
            var productValue = extract.extractProductValue(line);
            var product = createObjects.createProduct(productId, productValue);

            order.addProduct(product);
            user.addOrder(order);
            return user;
        } catch (NumberFormatException e) {
            System.out.println("500 Erro: Non-standard line for conversion");
        }
        return User.builder().build();
    }
}
