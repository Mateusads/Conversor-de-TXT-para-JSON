package br.com.converter.json.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IndexConvertType {
    INDEX_USER_ID(0, 10),
    INDEX_USER_NAME(10, 55),
    INDEX_ORDER_ID(55, 65),
    INDEX_PRODUCT_ID(65, 75),
    INDEX_PRODUCT_VALUE(76, 87),
    INDEX_ORDER_DATE(87, 96);

    private int start;
    private int end;
}
