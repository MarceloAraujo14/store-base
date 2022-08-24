package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ProductFindAllPageableImpl(
        ProductRepository productRepository
) {
    public List<Product> process(Integer page){
        return productRepository.listAllProductsPageable(page);
    }
}
