package com.mybang.khweb.service;

import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.repository.VillaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class VillaServiceImpl implements VillaService{

    @Autowired
    private VillaRepository repository;

    @Override
    public List<Villa> lists() throws Exception {
        List<Villa> villas = repository.findAll();

        return villas;
    }
}
