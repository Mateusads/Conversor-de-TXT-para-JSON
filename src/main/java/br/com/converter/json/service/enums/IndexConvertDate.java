package br.com.converter.json.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IndexConvertDate {

    YEAR(0, 4),
    MONTH(4,6),
    DAY(6,8);

    private int start;
    private int end;
}
