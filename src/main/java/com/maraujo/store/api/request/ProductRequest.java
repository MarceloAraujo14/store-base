package com.maraujo.store.api.request;

import java.math.BigDecimal;

public record ProductRequest(
        String productName,
        String substrate,
        String productDescription,
        double width,
        double height,
        Integer quantity,
        BigDecimal price
) {
}
