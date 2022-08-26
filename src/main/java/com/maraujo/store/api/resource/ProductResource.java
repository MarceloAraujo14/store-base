package com.maraujo.store.api.resource;

import com.maraujo.store.api.mapper.ProductRequestMapper;
import com.maraujo.store.api.request.ProductRequest;
import com.maraujo.store.core.domain.Product;
import com.maraujo.store.core.usecase.product.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping
public class ProductResource {

    private final RegisterProductImpl registerProduct;
    private final ProductFindByCodeImpl getProductByCode;
    private final ProductFindByNameImpl findProductByProductNameContains;
    private final ProductFindAllPageableImpl findAllPageable;
    private final ProductUpdateByCode updateByCode;
    private final ProductRequestMapper mapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/product")
    public ResponseEntity registerProduct(@RequestBody ProductRequest productRequest){
        log.info("registerProduct - Product Request: {}", productRequest);
        return ResponseEntity.ok(registerProduct.process(mapper.toProduct(productRequest)));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/product/{registrationCode}")
    public ResponseEntity findProductByCode(@PathVariable("registrationCode") Long registrationCode){
        log.info("findProductByCode - Registration Code: {}", registrationCode);
        return ResponseEntity.ok(getProductByCode.process(registrationCode));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/products/filter")
    public ResponseEntity<Page<Product>> findProductsByNameContains(@RequestParam("name") String name, Pageable page){
        log.info("findProductByNameContains - product name: {}", name);
        return ResponseEntity.ok(findProductByProductNameContains.process(name, page));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/products/page/{page}")
    public ResponseEntity<Page<Product>> findProductsByPage(@PathVariable("page") Integer page){
        log.info("findAllByPage - page: {}", page);
        return ResponseEntity.ok(findAllPageable.process(PageRequest.of(page, 10)));
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/product/{registrationCode}")
    public ResponseEntity updateProductByCode(@RequestBody ProductRequest productRequest,@PathVariable("registrationCode") Long code){
        log.info("registerProduct - Product Request: {}", productRequest);
        return ResponseEntity.ok(updateByCode.process(code, mapper.toProduct(productRequest)));
    }

}
