package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessingObject {

    private final ExtractDataService extract = new ExtractDataService();
    private final CreateObjects createObjects = new CreateObjects();
    private static Map<Integer, User> usersExisting = new HashMap<>();
    private static Map<Integer, Order> ordersExisting = new HashMap<>();

    public User processCreateObject(String line){

        var valuesCreateObjects = extract.extractDataLine(line);
        var newUser = createObjects.creatingUser(valuesCreateObjects, usersExisting);
        var newOrder = createObjects.createOrder(valuesCreateObjects, ordersExisting);
        var newProduct = createObjects.createProduct(valuesCreateObjects);
        usersExisting.put(newUser.getId(), newUser);
        ordersExisting.put(newOrder.getId(), newOrder);

        newOrder.addProduct(newProduct);
        newUser.addOrder(newOrder);
        return newUser;
    }
}
