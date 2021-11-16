package com.mybang.khweb.service;

import com.mybang.khweb.entity.SeoulDong;
import com.mybang.khweb.repository.SeoulDongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class SeoulDongServiceImpl implements SeoulDongService{

    @Autowired
    private SeoulDongRepository repository;

    @Override
    public List<SeoulDong> lists() throws Exception {
        return repository.findAll();
    }
}
