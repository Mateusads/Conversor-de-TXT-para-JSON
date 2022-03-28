package br.com.converter.json.service;

import java.time.LocalDate;

import static br.com.converter.json.service.enums.IndexConvertDate.*;
import static br.com.converter.json.service.enums.IndexConvertType.*;

public class ExtractDataService {

    public int extractUserId(String line){
        var userId = Integer.parseInt(extractDataIndex(line, INDEX_USER_ID.getStart(), INDEX_USER_ID.getEnd()));
        return userId;
    }

    public String extractUserName(String line){
        var userName = extractDataIndex(line, INDEX_USER_NAME.getStart(), INDEX_USER_NAME.getEnd()).trim();
        return userName;
    }

    public int extractOrderId(String line) throws NumberFormatException {
        var orderId = Integer.parseInt(extractDataIndex(line, INDEX_ORDER_ID.getStart(), INDEX_ORDER_ID.getEnd()));
        return orderId;
    }

    public LocalDate extractOrderDate(String line){
        var orderDate = parseLocalDate(extractDataIndex(line, INDEX_ORDER_DATE.getStart(), INDEX_ORDER_DATE.getEnd()));
        return orderDate;
    }

    public int extractProductId(String line) throws NumberFormatException {
        var productId = Integer.parseInt(extractDataIndex(line, INDEX_PRODUCT_ID.getStart(), INDEX_PRODUCT_ID.getEnd()));
        return productId;
    }

    public Double extractProductValue(String line) throws NumberFormatException {
        var productValue = Double.parseDouble(extractDataIndex(line, INDEX_PRODUCT_VALUE.getStart(), INDEX_PRODUCT_VALUE.getEnd()));
        return productValue;
    }

    private String extractDataIndex(String line, int start, int end){
        int lineSize = line.length();
        try {
            if (lineSize > end) {
                return line.substring(start, end);
            }
            if (lineSize < end && lineSize > start) {
                return line.substring(start, lineSize);
            } else
                throw new IndexOutOfBoundsException();
        }catch (IndexOutOfBoundsException e){
            System.out.println("500 Erro: Incorrect line size");
        }
        return ("");
    }

    private LocalDate parseLocalDate(String lineDate) {
        try{
            LocalDate transformedDate = LocalDate.of(Integer.parseInt(lineDate.substring(YEAR.getStart(), YEAR.getEnd())),
                    Integer.parseInt(lineDate.substring(MONTH.getStart(), MONTH.getEnd())),
                    Integer.parseInt(lineDate.substring(DAY.getStart(), DAY.getEnd())));
            return transformedDate;
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("500 Date conversion error: Check line pattern");
        }
        return LocalDate.now();
    }
}
