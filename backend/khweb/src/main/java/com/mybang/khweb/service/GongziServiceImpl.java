package com.mybang.khweb.service;

import com.mybang.khweb.entity.Gongzi;
import com.mybang.khweb.repository.GongziRepository;
import com.mybang.khweb.request.GongziRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@Lazy
@Slf4j
public class GongziServiceImpl implements GongziService{
    @Autowired
    private GongziRepository repository;

    @Override
    public void register(GongziRequest request) throws Exception {

        Gongzi gongziEntity = new Gongzi(request.getTitle(), request.getWriter(), request.getDescription());

        repository.save(gongziEntity);
    }

    @Override
    public List<Gongzi> list() throws Exception {
        return repository.findAll();
    }

    @Override
    public Gongzi read(Long gongziNo) throws Exception {

        Gongzi gongzi = repository.findByGongzi(gongziNo).orElse(null);

        return gongzi;
    }

    @Override
    public void remove(Long gongziNo) throws Exception {

        repository.deleteById(gongziNo);
    }

    @Override
    public void modify(Gongzi gongzi, GongziRequest request) throws Exception {
        gongzi.updateGongzi(request);
        repository.save(gongzi);
    }


}
