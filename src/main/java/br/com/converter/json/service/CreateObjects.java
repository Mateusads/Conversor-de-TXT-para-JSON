package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.Product;
import br.com.converter.json.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class CreateObjects {

    private Map<String, Object> objects = new HashMap<>();
    private final CreateUser createUser = new CreateUser();
    private final CreateOrder createOrder = new CreateOrder();
    private final CreateProduct createProduct = new CreateProduct();

    public void create(Map<String, Object> valuesCreate)  {
        /*try{
            var user = creatingUser(valuesCreate);
            var order = createOrder(valuesCreate);
            var product = createProduct(valuesCreate);
            order.addProduct(product);
            user.addOrder(order);
            return user;
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return User.builder().build();*/
    }

    public User creatingUser(Map<String, Object> valuesCreate, Map<Integer, User> users) throws NullPointerException{
        var userId = (Integer) valuesCreate.get("userId");
        var userName = (String) valuesCreate.get("userName");
        if(users.containsKey(userId)) return users.get(userId);
        return createUser.create(userId, userName);
    }

    public Order createOrder(Map<String, Object> valuesCreate, Map<Integer, Order> orders) throws NullPointerException{
        var orderId = (Integer) valuesCreate.get("orderId");
        var orderDate = (LocalDate) valuesCreate.get("orderDate");
        if(orders.containsKey(orderId)) return orders.get(orderId);
        return createOrder.create(orderId, orderDate);
    }

        public Product createProduct(Map<String, Object> valuesCreate) throws NullPointerException{
        var productId = (Integer) valuesCreate.get("productId");
        var productValue = (Double) valuesCreate.get("productValue");
        return createProduct.create(productId, productValue);
    }

}
