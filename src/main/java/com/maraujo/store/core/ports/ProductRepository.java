package com.maraujo.store.core.ports;

import com.maraujo.store.core.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository {

    Product save(Product product);

    Product findByCode(Long registrationCode);

    Page<Product> listAllProductsPageable(Pageable page);

    Page<Product> findByProductName(String name, Pageable pageable);

    void deleteByCode(Long registrationCode);


}
