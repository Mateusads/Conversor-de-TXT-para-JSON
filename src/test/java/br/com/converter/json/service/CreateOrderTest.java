package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderTest extends TestCase {

    @Test
    public void testCreatingOrderForBuilder(){
        LocalDate date = LocalDate.of(2022, 03, 10);

        var order = Order.builder()
                .id(1)
                .date(date)
                .build();

        assertThat(order.getId()).isEqualTo(1);
        assertThat(order.getDate().toString()).isEqualTo("2022/03/10");
    }
}