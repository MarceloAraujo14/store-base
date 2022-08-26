package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;
import org.springframework.data.domain.Page;

public interface ProductFindByProductNameContains {

    Page<Product> process(String name);
}
