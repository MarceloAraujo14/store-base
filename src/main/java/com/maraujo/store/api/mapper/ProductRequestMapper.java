package com.maraujo.store.api.mapper;

import com.maraujo.store.api.request.ProductRequest;
import com.maraujo.store.core.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper {

    public Product toProduct(ProductRequest productRequest){
        return Product.builder()
                .productName(productRequest.productName())
                .substrate(productRequest.substrate())
                .productDescription(productRequest.productDescription())
                .height(productRequest.height())
                .width(productRequest.width())
                .quantity(productRequest.quantity())
                .price(productRequest.price())
                .build();
    }

}
