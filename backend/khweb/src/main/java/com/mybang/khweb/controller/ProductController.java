package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.repository.ProductRepository;
import com.mybang.khweb.request.ProductRequest;
import com.mybang.khweb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody ProductRequest request) throws Exception {
        log.info("register():");

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list() throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{productNo}")
    public ResponseEntity<Product> read(@PathVariable("productNo") Long productNo) throws Exception {
        log.info("read");

        Product product = service.read(productNo);

        log.info("Product Read Success");

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{productNo}")
    public ResponseEntity<Void> remove(@PathVariable("productNo") Long productNo) throws Exception {
        service.remove(productNo);

        log.info("Fun+++++++++++++++++" +
                "0.0.ding Delete Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{productNo}")
    public ResponseEntity<Void> update(@PathVariable("productNo") Long productNo,
                                       @RequestBody ProductRequest request) throws Exception {

        Optional<Product> product = repository.findByProduct(productNo);
        Product read = product.get();
        service.modify(read, request);

        log.info("Product Update Success");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getProductInfo/{productNo}")
    public ResponseEntity<Product> getProductInfo(@PathVariable("productNo") Integer productNo) {
        log.info("getProductInfo(): " + productNo);

        return new ResponseEntity<Product>(service.getProductInfo(productNo), HttpStatus.OK);

    }
}
