package com.maraujo.store.core.usecase.product;

import com.maraujo.store.core.domain.Product;

public interface ProductFindByCode {

    Product process(Long registrationCode);
}
