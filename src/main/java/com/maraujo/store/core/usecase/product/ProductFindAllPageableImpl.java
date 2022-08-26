package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public record ProductFindAllPageableImpl(
        ProductRepository productRepository
) {
    public Page<Product> process(Pageable page){
        return productRepository.listAllProductsPageable(page);
    }
}
