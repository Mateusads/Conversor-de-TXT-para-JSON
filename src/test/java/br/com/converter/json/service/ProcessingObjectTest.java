package br.com.converter.json.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessingObjectTest {

    @Mock
    private ExtractDataService extractDataService;

    @InjectMocks
    private ProcessingObject processing;

    private  String line;

    @BeforeEach
    public void preparingTestScenario(){
        MockitoAnnotations.initMocks(this);
        this.line = "0000000071                               Everett Beahan00000007610000000004    1881.5420210702";
    }

    @Test
    public void shouldProcessLineCreateUser(){
        createWhenMock();
        var newUser = processing.processCreateObject(line);

        assertThat(newUser.getId()).isEqualTo(71);
        assertThat(newUser.getName()).isEqualTo("Everett Beahan");

        verify(extractDataService, times(1)).extractUserId(line);
        verify(extractDataService, times(1)).extractUserName(line);
        verify(extractDataService, times(1)).extractOrderId(line);
        verify(extractDataService, times(1)).extractOrderDate(line);
        verify(extractDataService, times(1)).extractProductId(line);
        verify(extractDataService, times(1)).extractProductValue(line);

    }

    private void createWhenMock() {
        int userId = 71;
        String userName = "Everett Beahan";
        int orderId = 761;
        LocalDate orderDate = LocalDate.of(2021,7,02);
        int productId = 4;
        double productValue = 1881.542;

        when(extractDataService.extractUserId(line)).thenReturn(userId);
        when(extractDataService.extractUserName(line)).thenReturn(userName);
        when(extractDataService.extractOrderId(line)).thenReturn(orderId);
        when(extractDataService.extractOrderDate(line)).thenReturn(orderDate);
        when(extractDataService.extractProductId(line)).thenReturn(productId);
        when(extractDataService.extractProductValue(line)).thenReturn(productValue);
    }

}