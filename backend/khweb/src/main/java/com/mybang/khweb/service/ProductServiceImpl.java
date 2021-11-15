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

        Product productEntity = new Product(request.getAddress(), request.getAgentAddress(), request.getAgentEmail(),
                request.getAgentLat(), request.getAgentLng(), request.getAgentMobile(), request.getAgentName(),
                request.getAgentPhone(), request.getBuildingType(), request.getDeposit(), request.getDescription(),
                request.getElevator(), request.getFloor(), request.getFloorAll(), request.getImage(), request.getLat(),
                request.getLng(), request.getLocal1(), request.getLocal2(), request.getLocal3(), request.getManageCost(),
                request.getManageCostInc(), request.getMoveinDate(), request.getNearSubways(), request.getOptions(),
                request.getParking(), request.getPets(), request.getRoomDirection(), request.getRoomType(), request.getSalesType(),
                request.getServiceType(), request.getSize(), request.getSizeM2(), request.getTitle(), request.getUpdatedAt(),
                request.getUserIntro(), request.getUserName(), request.getUrl(), request.getMonthlyRent());

        repository.save(productEntity);

    }

    @Override
    public List<Product> list() throws Exception {
        return repository.findAll();
    }

    @Override
    public Product read(Long productNo) throws Exception {

        Optional<Product> productRead = repository.findByProduct(productNo);

        return productRead.get();
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
