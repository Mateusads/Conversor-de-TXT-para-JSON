package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.Product;
import br.com.converter.json.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class CreateObjects {

    private Map<String, Object> objects = new HashMap<>();
    private CreateUser createUser = new CreateUser();
    private CreateOrder createOrder = new CreateOrder();
    private CreateProduct createProduct = new CreateProduct();

    public User create(Map<String, Object> valuesCreate)  {
        try{
            var userId = (int) valuesCreate.get("userId");
            var userName = (String) valuesCreate.get("userName");
            var user = createUser(userId, userName);

            var orderId = (int) valuesCreate.get("orderId");
            var orderDate = (LocalDate) valuesCreate.get("orderDate");
            var order = createOrder(orderId, orderDate);

            var productId = (int) valuesCreate.get("productId");
            var productValue = (double) valuesCreate.get("productValue");
            var product = createProduct(productId, productValue);

            order.addProduct(product);
            user.addOrder(order);
            return user;
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return User.builder().build();
    }

    public User createUser(int userId, String userName){
        return createUser.create(userId, userName);
    }

    public Order createOrder(int id, LocalDate date){
        return createOrder.create(id, date);
    }

    public Product createProduct(int id, double value){
        return createProduct.create(id, value);
    }
}
