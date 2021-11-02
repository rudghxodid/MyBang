package com.mybang.khweb.service;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.request.ProductRequest;

import java.util.List;

public interface ProductService {

    public void register(ProductRequest request) throws Exception;

    public List<Product> list() throws Exception;

    public Product read(Long productNo) throws Exception;

    public void remove(Long productNo) throws Exception;

    public void modify(Product product, ProductRequest request) throws Exception;

    // 찜하기
    public Product getProductInfo(Integer productNo);
}
