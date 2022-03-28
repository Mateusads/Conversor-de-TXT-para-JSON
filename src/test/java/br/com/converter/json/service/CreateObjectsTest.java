package br.com.converter.json.service;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateObjectsTest {

    private CreateObjects createObjects;

    @Before
    public void preparingTestScenario(){
        createObjects = new CreateObjects();
    }

    @Test
    public void shouldCreateUserFromParam(){
        int userId = 1;
        String userName = "Mateus Medeiros";
        var user = createObjects.creatingUser(userId, userName);
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("Mateus Medeiros");
    }

    @Test
    public void shouldCreateOrderFromParam(){
        int orderId = 10;
        LocalDate date = LocalDate.of(2022,03,10);
        var order = createObjects.createOrder(orderId, date);

        assertThat(order.getId()).isEqualTo(10);
        assertThat(order.getDate().toString()).isEqualTo("2022-03-10");
    }

    @Test
    public void shouldCreateProductFromParam(){
        int productId = 23;
        Double value = 1.30D;
        var product = createObjects.createProduct(productId, value);

        assertThat(product.getId()).isEqualTo(23);
        assertThat(product.getValue()).isEqualTo(1.30D);
    }
}