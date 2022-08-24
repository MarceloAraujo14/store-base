package com.maraujo.store.adapters.dataprovider;

import com.maraujo.store.adapters.dataprovider.entity.ProductEntity;
import com.maraujo.store.adapters.dataprovider.mapper.ProductMapper;
import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.ports.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.maraujo.store.api.util.PageUtils.formatPageSearch;

@Log4j2
@Service
public record ProductRepositoryGateway(
        ProductJpaRepository productJpaRepository,
        ProductMapper mapper) implements ProductRepository {

    @Override
    public Product save(Product product) {
        log.info("PROCESSING - save - Product Request: {}", product);
        Product saveProduct = mapper.toProduct(
                productJpaRepository.save(
                        mapper.toEntity(product)));
        log.info("SUCCESS - product save: {}", saveProduct);
        return saveProduct;
    }

    @Override
    public Product findByCode(Long registrationCode) {
        log.info("PROCESSING - findByCode - Registration code: {}", registrationCode);
        ProductEntity productEntity = productJpaRepository.getReferenceById(registrationCode);
        log.info("SUCCESS - findByCode - product: {}", productEntity);
        return mapper.toProduct(
                productEntity);
    }

    @Override
    public Product findByName(String productName) {
        log.info("PROCESSING - findByName - product name: {}", productName);
        ProductEntity product = productJpaRepository.findByProductName(productName);
        log.info("SUCCESS - findByName - product: {}", product);
        return mapper.toProduct(
                product);
    }

    @Override
    public List<Product> listAllProductsPageable(Integer page) {
        log.info("PROCESSING - listAllProductsPageable - page: {}", page);
        page = formatPageSearch(page);
        return mapper.toProductList(
                productJpaRepository.findAll(PageRequest.of(page, 10)));
    }

    @Override
    public List<Product> findByProductNameContains(String name) {
        log.info("PROCESSING - findByProductNameContains - product name: {}", name);
        List<ProductEntity> productList = productJpaRepository.findByProductNameContains(name);
        return mapper.toProductList(
                productList);
    }

    @Override
    public void deleteByCode(Long registrationCode) {
        log.info("PROCESSING - deleteByCode - registration code: {}", registrationCode);
        productJpaRepository.deleteById(registrationCode);
        log.info("SUCCESS - deleteByCode");
    }
}
