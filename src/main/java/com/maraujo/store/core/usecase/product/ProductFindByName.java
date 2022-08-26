package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductFindByName {

    Page<Product> process(String name, Pageable page);
}
