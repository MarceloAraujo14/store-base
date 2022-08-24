package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public record ProductFindByNameImpl(
        ProductRepository repository) implements ProductFindByName {

    public Product process(String productName) {
        log.info("PROCESSING - product name: {}", productName);
        Product product = repository.findByName(productName);
        log.info("SUCCESS - product {}", product);
        return product;
    }
}
