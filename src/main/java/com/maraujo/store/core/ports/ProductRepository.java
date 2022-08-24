package com.maraujo.store.core.ports;

import com.maraujo.store.core.domain.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    Product findByCode(Long registrationCode);

    Product findByName(String productName);

    List<Product> listAllProductsPageable(Integer page);

    List<Product> findByProductNameContains(String name);

    void deleteByCode(Long registrationCode);


}
