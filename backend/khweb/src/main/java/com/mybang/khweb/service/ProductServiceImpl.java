package com.mybang.khweb.service;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.repository.ProductRepository;
import com.mybang.khweb.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void register(ProductRequest request) throws Exception {

        Product productEntity = new Product(request.getId(), request.getTitle(), request.getDescription(), request.getDeposit(),
                request.getAgent_name(), request.getAgent_mobile(), request.getFloor(), request.getAddress(),
                request.getSize(), request.getSize_m2(), request.getStatus(), request.getRoom_type(),
                request.getManage_cost_inc(), request.getUpdated_at2(), request.getUrl());

        repository.save(productEntity);

    }
}
