package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public record RegisterProductImpl(
        ProductRepository repository) implements RegisterProduct {

    @Override
    public Product process(Product product) {
        log.info("PROCESSING - product request: {}", product);
        Product savedProduct = repository.save(product);
        log.info("SUCCESS - product saved {}", savedProduct);
        return savedProduct;
    }
}
