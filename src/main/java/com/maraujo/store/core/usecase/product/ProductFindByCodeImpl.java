package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public record ProductFindByCodeImpl(
        ProductRepository productRepository) implements ProductFindByCode {

    @Override
    public Product process(Long registrationCode) {
        log.info("PROCESSING - registration code: {}", registrationCode);
        Product product = productRepository.findByCode(registrationCode);
        log.info("SUCCESS - product: {}", product);
        return product;
    }
}
