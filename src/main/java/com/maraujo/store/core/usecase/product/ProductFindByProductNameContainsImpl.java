package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public record ProductFindByProductNameContainsImpl(
        ProductRepository repository) implements ProductFindByProductNameContains {

    public List<Product> process(String name) {
        log.info("PROCESSING - product name: {}", name);
        List<Product> products = repository.findByProductNameContains(name);
        log.info("SUCCESS - product list: {}", products);
        return products;
    }
}
