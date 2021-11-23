package com.mybang.khweb.service;

import com.mybang.khweb.entity.Officetel;
import com.mybang.khweb.repository.OfficetelRepository;
import com.mybang.khweb.request.OfficetelRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
@Slf4j
public class OfficetelServiceImpl implements OfficetelService{

    @Autowired
    private OfficetelRepository repository;

    @Override
    public void register(OfficetelRequest request) throws Exception {
        Officetel officetel = repository.save(request.toEntity());
    }

    @Override
    public List<Officetel> lists() throws Exception {
        List<Officetel> officetels = repository.findAll();

        return officetels;
    }

    @Override
    public Optional<Officetel> read(Long officetelNo) throws Exception {

        Optional<Officetel> officetelRead = repository.findByOfficetelNo(officetelNo);

        return officetelRead;
    }

    @Override
    public void remove(Long officetelNo) throws Exception {

        repository.deleteById(officetelNo);
    }

    @Override
    public void modify(Officetel officetel, OfficetelRequest request) throws Exception {

        officetel.updateOfficetel(request);
        repository.save(officetel);
    }

    @Override
    public List<Officetel> agentList(String agnetId) throws Exception {

        List<Officetel> officetelLists = repository.findByAgentId(agnetId);

        return officetelLists;
    }
}
