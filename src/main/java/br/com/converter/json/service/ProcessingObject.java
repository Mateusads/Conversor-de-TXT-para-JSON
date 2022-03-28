package br.com.converter.json.service;

import br.com.converter.json.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProcessingObject {

    private ExtractDataService extract;
    private CreateObjects createObjects;

    public ProcessingObject(){
        this.extract = new ExtractDataService();
        createObjects = new CreateObjects();
    }

    public ProcessingObject(CreateObjects createObjects) {
        this.extract = new ExtractDataService();
        this.createObjects = createObjects;
    }

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
