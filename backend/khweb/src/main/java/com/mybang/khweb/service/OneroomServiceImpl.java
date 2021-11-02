package com.mybang.khweb.service;

import com.mybang.khweb.entity.Oneroom;
import com.mybang.khweb.repository.OneroomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class OneroomServiceImpl implements OneroomService{

    @Autowired
    private OneroomRepository repository;

    @Override
    public List<Oneroom> lists() throws Exception {
        List<Oneroom> onerooms = repository.findAll();

        return onerooms;
    }
}
