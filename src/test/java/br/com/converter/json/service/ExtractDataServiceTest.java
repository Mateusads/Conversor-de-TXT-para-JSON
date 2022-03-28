package br.com.converter.json.service;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtractDataServiceTest {

    private ExtractDataService extract;
    private static String line;

    @Before
    public void preparingTestScenario(){
        this.extract = new ExtractDataService();
        line = "0000000071                               Everett Beahan00000007610000000004    1881.5420210702";
    }

    @Test
    public void shouldExtractUserIdFromLine() {
        var userId = extract.extractUserId(line);
        assertThat(userId).isEqualTo(71);
    }

    @Test
    public void shouldExtractUserNameFromLine(){
        var userName = extract.extractUserName(line);
        assertThat(userName).isEqualTo("Everett Beahan");
    }

    @Test
    public void shouldExtractOrderIdFromLine(){
        var orderId = extract.extractOrderId(line);
        assertThat(orderId).isEqualTo(761);
    }

    @Test
    public void shouldExtractOrderDateFromLine(){
        var orderDate = extract.extractOrderDate(line);
        assertThat(orderDate.toString()).isEqualTo("2022-03-28");
    }

    @Test
    public void shouldExtractProductIdFromLine(){
        var productId = extract.extractProductId(line);
        assertThat(productId).isEqualTo(4);
    }

    @Test
    public void shouldExtractProductValueFromLine(){
        var productValue = extract.extractProductValue(line);
        assertThat(productValue).isEqualTo(1881.542D);
    }

}