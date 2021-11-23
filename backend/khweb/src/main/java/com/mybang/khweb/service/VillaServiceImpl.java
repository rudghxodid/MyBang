package com.mybang.khweb.service;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.repository.VillaRepository;
import com.mybang.khweb.request.ProductRequest;
import com.mybang.khweb.request.VillaRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
@Slf4j
public class VillaServiceImpl implements VillaService{

    @Autowired
    private VillaRepository repository;

    @Override
    public void register(VillaRequest request) throws Exception {
        Villa villa = repository.save(request.toEntity());
    }

    @Override
    public List<Villa> lists() throws Exception {
        List<Villa> villas = repository.findAll();

        return villas;
    }

    @Override
    public Optional<Villa> read(Long villaNo) throws Exception {

        Optional<Villa> villaRead = repository.findByVillaNo(villaNo);

        return villaRead;
    }

    @Override
    public void remove(Long villaNo) throws Exception {

        repository.deleteById(villaNo);
    }

    @Override
    public void modify(Villa villa, VillaRequest request) throws Exception {

        villa.updateVilla(request);
        repository.save(villa);
    }

    @Override
    public List<Villa> agentList(String agentId) throws Exception {

        //List<Villa> villaLists = repository.findByAgentId(agentId);

        // return villaLists

        return repository.findByAgentId(agentId);
    }
}
