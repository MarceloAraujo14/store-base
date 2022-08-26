package com.maraujo.store.core.ports;

import com.maraujo.store.core.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository {

    Product save(Product product);

    Product findByCode(Long registrationCode);

    Product findByName(String productName);

    Page<Product> listAllProductsPageable(Pageable page);

    Page<Product> findByProductNameContains(String name);

    void deleteByCode(Long registrationCode);


}
