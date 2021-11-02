package com.mybang.khweb.service;

import com.mybang.khweb.entity.Officetel;
import com.mybang.khweb.repository.OfficetelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class OfficetelServiceImpl implements OfficetelService{

    @Autowired
    private OfficetelRepository repository;

    @Override
    public List<Officetel> lists() throws Exception {
        List<Officetel> officetels = repository.findAll();

        return officetels;
    }
}
