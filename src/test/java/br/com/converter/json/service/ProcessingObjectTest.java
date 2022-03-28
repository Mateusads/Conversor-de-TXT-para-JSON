package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.Product;
import br.com.converter.json.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class ProcessingObjectTest {

    @Mock
    private CreateObjects createObjects;

    @InjectMocks
    private ProcessingObject processing;

    private  String line;
    private  LocalDate date = LocalDate.of(2022,3,28);
    private  String userName = "Everett Beahan";
    private  double productValue = 1881.542;

    @Before
    public void preparingTestScenario() throws IOException {
        this.createObjects = createMockObjects();
        this.processing = new ProcessingObject(createObjects);
        this.line = "0000000071                               Everett Beahan00000007610000000004    1881.5420210702";
    }

    @Test
    public void shouldProcessLineCreateUser(){

        var newUser = processing.processCreateObject(line);

        assertThat(newUser.getId()).isEqualTo(71);
        assertThat(newUser.getName()).isEqualTo("Everett Beahan");

        verify(createObjects, times(1)).creatingUser(71, "Everett Beahan");
        verify(createObjects, times(1)).createOrder(761, date);
        verify(createObjects, times(1)).createProduct(4, productValue);
    }

    private Object createOneObjectForContext(String objectForCreate){
        if(objectForCreate.equals("user")) return User.builder().id(71).name("Everett Beahan").build();
        if(objectForCreate.equals("order")) return Order.builder().id(761).date(date).build();
        if(objectForCreate.equals("product")) return Product.builder().id(4).value(productValue).build();
        return Object.class;
    }

    private CreateObjects createMockObjects() {
        CreateObjects createObjects = mock(CreateObjects.class);
        User userMock = (User) createOneObjectForContext("user");
        Order orderMock = (Order) createOneObjectForContext("order");
        Product productMock = (Product) createOneObjectForContext("product");
        when(createObjects.creatingUser(71, userName)).thenReturn(userMock);
        when(createObjects.createOrder(761, date)).thenReturn(orderMock);
        when(createObjects.createProduct(4, productValue)).thenReturn(productMock);
        return createObjects;
    }
}