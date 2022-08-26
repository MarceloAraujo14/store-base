package com.maraujo.store.adapters.dataprovider.h2repository;

import com.maraujo.store.adapters.dataprovider.h2repository.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByProductName(String productName);

    @Query(value = "SELECT p FROM product_tb p WHERE p.productName LIKE %:productName%")
    Page<ProductEntity> findByProductNameContains(@Param("productName") String productName);
}
