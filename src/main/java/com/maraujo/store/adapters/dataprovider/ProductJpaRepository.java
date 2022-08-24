package com.maraujo.store.adapters.dataprovider;

import com.maraujo.store.adapters.dataprovider.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByProductName(String productName);

    @Query(value = "SELECT p FROM product_tb p WHERE p.productName LIKE %:productName%")
    List<ProductEntity> findByProductNameContains(@Param("productName") String productName);
}
