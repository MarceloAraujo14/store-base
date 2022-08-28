package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Log4j2
@Service
public record ProductFindByNameImpl(
        ProductRepository repository) implements ProductFindByName {

    public Page<Product> process(String name, Pageable page) {
        name = name.toUpperCase(Locale.ROOT);
        log.info("PROCESSING - product name: {}", name);
        Page<Product> products = repository.findByProductName(name, page);
        log.info("SUCCESS - product list: {}", products.getContent());
        return products;
    }
}
