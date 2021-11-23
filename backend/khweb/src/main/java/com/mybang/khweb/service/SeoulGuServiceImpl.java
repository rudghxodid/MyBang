package com.mybang.khweb.service;

import com.mybang.khweb.entity.SeoulGu;
import com.mybang.khweb.repository.SeoulGuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class SeoulGuServiceImpl implements SeoulGuService{

    @Autowired
    private SeoulGuRepository repository;

    @Override
    public List<SeoulGu> lists() throws Exception {
        return repository.findAll();
    }
}
