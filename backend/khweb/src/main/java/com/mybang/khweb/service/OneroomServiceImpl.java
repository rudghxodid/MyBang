package com.mybang.khweb.service;

import com.mybang.khweb.entity.Oneroom;
import com.mybang.khweb.repository.OneroomRepository;
import com.mybang.khweb.request.OneroomRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
@Slf4j
public class OneroomServiceImpl implements OneroomService{

    @Autowired
    private OneroomRepository repository;

    @Override
    public void register(OneroomRequest request) throws Exception {
        Oneroom oneroom = repository.save(request.toEntity());
    }

    @Override
    public List<Oneroom> lists() throws Exception {
        List<Oneroom> onerooms = repository.findAll();

        return onerooms;
    }

    @Override
    public Optional<Oneroom> read(Long oneroomNo) throws Exception {

        Optional<Oneroom> oneroomRead = repository.findByOneroomNo(oneroomNo);

        return oneroomRead;
    }

    @Override
    public void remove(Long oneroomNo) throws Exception {

        repository.deleteById(oneroomNo);
    }

    @Override
    public void modify(Oneroom oneroom, OneroomRequest request) throws Exception {

        oneroom.updateOneroom(request);
        repository.save(oneroom);
    }

    @Override
    public List<Oneroom> agentList(String agnetId) throws Exception {

        List<Oneroom> oneroomLists = repository.findByAgentId(agnetId);

        return oneroomLists;
    }
}
