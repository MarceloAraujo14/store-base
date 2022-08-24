package com.maraujo.store.adapters.dataprovider.mapper;

import com.maraujo.store.adapters.dataprovider.entity.ProductEntity;
import com.maraujo.store.core.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class ProductMapper {

    public ProductEntity toEntity(Product product){
        return ProductEntity.builder()
                .registrationCode(product.getRegistrationCode())
                .productName(product.getProductName().toUpperCase(Locale.ROOT))
                .substrate(product.getSubstrate().toUpperCase(Locale.ROOT))
                .productDescription(product.getProductDescription())
                .height(product.getHeight())
                .width(product.getWidth())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }

    public Product toProduct(ProductEntity entity){
        return Product.builder()
                .registrationCode(entity.getRegistrationCode())
                .productName(entity.getProductName())
                .substrate(entity.getSubstrate())
                .productDescription(entity.getProductDescription())
                .height(entity.getHeight())
                .width(entity.getWidth())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .build();
    }

    public List<Product> toProductList(Page<ProductEntity> list){
        return
                list.stream().map(this::toProduct).toList();
    }

    public List<Product> toProductList(List<ProductEntity> list){
        return
                list.stream().map(this::toProduct).toList();
    }

}
