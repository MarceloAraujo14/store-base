package com.maraujo.store.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long registrationCode;
    private String productName;
    private String substrate;
    private String productDescription;
    private double width;
    private double height;
    private Integer quantity;
    private BigDecimal price;

}
