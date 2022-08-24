package com.maraujo.store.api.resource;

import com.maraujo.store.api.mapper.ProductRequestMapper;
import com.maraujo.store.api.request.ProductRequest;
import com.maraujo.store.core.usecase.product.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductResource {

    private final RegisterProductImpl registerProduct;
    private final ProductFindByCodeImpl getProductByCode;
    private final ProductFindByNameImpl getProductByName;
    private final ProductFindByProductNameContainsImpl findProductByProductNameContains;
    private final ProductFindAllPageableImpl findAllPageable;
    private final ProductUpdateByCode updateByCode;
    private final ProductRequestMapper mapper;

    @PostMapping()
    public ResponseEntity registerProduct(@RequestBody ProductRequest productRequest){
        log.info("registerProduct - Product Request: {}", productRequest);
        return ResponseEntity.ok(registerProduct.process(mapper.toProduct(productRequest)));
    }

    @GetMapping(value = "/{registrationCode}")
    public ResponseEntity findProductByCode(@PathVariable("registrationCode") Long registrationCode){
        log.info("findProductByCode - Registration Code: {}", registrationCode);
        return ResponseEntity.ok(getProductByCode.process(registrationCode));
    }

    @GetMapping()
    public ResponseEntity findProductByName(@RequestParam("name") String name){
        log.info("findProductByName - product name: {}", name);
        return ResponseEntity.ok(getProductByName.process(name));
    }

    @GetMapping(value = "/filter")
    public ResponseEntity findProductByNameContains(@RequestParam("name") String name){
        log.info("findProductByNameContains - product name: {}", name);
        return ResponseEntity.ok(findProductByProductNameContains.process(name));
    }

    @GetMapping("/page/{page}")
    public ResponseEntity findProductByPage(@PathVariable("page") Integer page){
        log.info("findAllByPage - page: {}", page);
        return ResponseEntity.ok(findAllPageable.process(page).toString() + "\n Page: " + page);
    }

    @PutMapping("/{registrationCode}")
    public ResponseEntity updateProductByCode(@RequestBody ProductRequest productRequest,@PathVariable("registrationCode") Long code){
        log.info("registerProduct - Product Request: {}", productRequest);
        return ResponseEntity.ok(updateByCode.process(code, mapper.toProduct(productRequest)));
    }

}
