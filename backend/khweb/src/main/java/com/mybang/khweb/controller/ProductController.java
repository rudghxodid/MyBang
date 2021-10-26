package com.mybang.khweb.controller;

import com.mybang.khweb.request.ProductRequest;
import com.mybang.khweb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Validated @RequestBody ProductRequest request) throws Exception {
        log.info("register():" + request.getTitle() + request.getAgent_name());

        service.register(request);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
