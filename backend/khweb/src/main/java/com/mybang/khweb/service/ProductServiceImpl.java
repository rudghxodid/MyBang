package com.mybang.khweb.service;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.repository.ProductRepository;
import com.mybang.khweb.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void register(ProductRequest request) throws Exception {

        Product productEntity = new Product(request.getTitle(), request.getImage(), request.getDescription(),
                request.getDeposit(), request.getPrice(), request.getAgent_name(), request.getAgent_mobile(),
                request.getFloor(), request.getAddress(), request.getSize(),
                request.getSize_m2(), request.getStatus(), request.getRoom_type(), request.getManage_cost_inc());

        repository.save(productEntity);

    }

    @Override
    public List<Product> list() throws Exception {
        return repository.findAll();
    }

    @Override
    public Product read(Long productNo) throws Exception {

        Optional<Product> fundingRead = repository.findByProduct(productNo);

        return fundingRead.get();
    }

    @Override
    public void remove(Long productNo) throws Exception {

        repository.deleteById(productNo);
    }

    @Override
    public void modify(Product product, ProductRequest request) throws Exception {

        product.updateProduct(request);
        repository.save(product);
    }

    //찜하기
    @Override
    public Product getProductInfo(Integer productNo) {
        return repository.findById(new Long(productNo)).get();
    }
}
