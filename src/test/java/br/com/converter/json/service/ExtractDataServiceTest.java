package br.com.converter.json.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtractDataServiceTest {

    private ExtractDataService extract;
    private static String line;

    @BeforeEach
    public void preparingTestScenario() {
        extract = new ExtractDataService();
        line = "0000000075                                  Bobbie Batz00000007980000000226     1578.5720211116";
    }

    @Test
    public void shouldExtractUserIdFromLine() {
        var userId = extract.extractUserId(line);
        assertThat(userId).isEqualTo(75);
    }

    @Test
    public void shouldExtractUserNameFromLine() {
        var userName = extract.extractUserName(line);
        assertThat(userName).isEqualTo("Bobbie Batz");
    }

    @Test
    public void shouldExtractOrderIdFromLine() {
        var orderId = extract.extractOrderId(line);
        assertThat(orderId).isEqualTo(798);
    }

    @Test
    public void shouldExtractOrderDateFromLine() {
        var orderDate = extract.extractOrderDate(line);
        assertThat(orderDate.toString()).isEqualTo("2021-11-16");
    }

    @Test
    public void shouldExtractProductIdFromLine() {
        var productId = extract.extractProductId(line);
        assertThat(productId).isEqualTo(226);
    }

    @Test
    public void shouldExtractProductValueFromLine() {
        var productValue = extract.extractProductValue(line);
        assertThat(productValue).isEqualTo(1578.57D);
    }

}