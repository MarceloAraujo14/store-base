package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public record ProductUpdateByCode(ProductFindByCodeImpl findByCode, ProductRepository repository) {

    public Product process(Long code, Product productToUpdate){
        Product product = findByCode.process(code);
        return repository.save(update(product, productToUpdate));
    }

    private Product update(Product product, Product toUpdate){
        return Product.builder()
                .registrationCode(product.getRegistrationCode())
                .productName(Objects.nonNull(toUpdate.getProductName())? toUpdate.getProductName() : product.getProductName())
                .productDescription(Objects.nonNull(toUpdate.getProductDescription())? toUpdate.getProductDescription() : product.getProductDescription())
                .substrate(Objects.nonNull(toUpdate.getSubstrate())? toUpdate.getSubstrate() : product.getSubstrate())
                .height(Objects.nonNull(toUpdate.getHeight())? toUpdate.getHeight() : product.getHeight())
                .width(Objects.nonNull(toUpdate.getWidth())? toUpdate.getWidth() : product.getWidth())
                .quantity(Objects.nonNull(toUpdate.getQuantity())? toUpdate.getQuantity() : product.getQuantity())
                .price(Objects.nonNull(toUpdate.getPrice())? toUpdate.getPrice() : product.getPrice())
                .build();
    }
}
