package br.com.converter.json.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static br.com.converter.json.service.enums.IndexConvertType.*;

public class ExtractDataService {

    public Map<String, Object> extractDataLine(String line) {

        var userId = Integer.parseInt(extractDataIndex(line, INDEX_USER_ID.getStart(), INDEX_USER_ID.getEnd()));
        var userName = extractDataIndex(line, INDEX_USER_NAME.getStart(), INDEX_USER_NAME.getEnd());
        var orderId = Integer.parseInt(extractDataIndex(line, INDEX_ORDER_ID.getStart(), INDEX_ORDER_ID.getEnd()));
        var orderDate = parseLocalDate(extractDataIndex(line, INDEX_ORDER_DATE.getStart(), INDEX_ORDER_DATE.getEnd()));
        var productId = Integer.parseInt(extractDataIndex(line, INDEX_PRODUCT_ID.getStart(), INDEX_PRODUCT_ID.getEnd()));
        var productValue = Double.parseDouble(extractDataIndex(line, INDEX_PRODUCT_VALUE.getStart(), INDEX_PRODUCT_VALUE.getEnd()));
        return createMapObjects(userId, userName, orderId, orderDate, productId, productValue);
    }

    private Map<String, Object> createMapObjects(int userId, String userName, int orderId, LocalDate orderDate, int productId, double productValue) {
        Map<String, Object> valuesLine = new HashMap<>();
        valuesLine.put("userId", userId);
        valuesLine.put("userName", userName);
        valuesLine.put("orderId", orderId);
        valuesLine.put("orderDate", orderDate);
        valuesLine.put("productId", productId);
        valuesLine.put("productValue", productValue);
        return valuesLine;
    }

    private String extractDataIndex(String line, int start, int end){
        if (line.length() < start || line.length() < end) {
            if(line.length() >= start){
                return line.substring(start, line.length());
            }else
                return line.substring(0, line.length());
        } else {
            return line.substring(start, end);
        }
    }

    private LocalDate parseLocalDate(String lineDate) {
        LocalDate transformedDate = LocalDate.of(Integer.parseInt(lineDate.substring(0, 4)),
                Integer.parseInt(lineDate.substring(4, 6)),
                Integer.parseInt(lineDate.substring(6, 8)));
        return transformedDate;
    }

}
