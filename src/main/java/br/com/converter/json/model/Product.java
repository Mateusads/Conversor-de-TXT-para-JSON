package br.com.converter.json.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    private int id;
    private double value;
}
