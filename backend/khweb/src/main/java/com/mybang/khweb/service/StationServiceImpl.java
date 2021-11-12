package com.mybang.khweb.service;

import com.mybang.khweb.entity.Station;
import com.mybang.khweb.repository.StationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
@Slf4j
public class StationServiceImpl implements StationService{

    @Autowired
    private StationRepository repository;

    @Override
    public List<Station> lists() throws Exception {
        List<Station> stations = repository.findAll();

        return stations;
    }

    @Override
    public List<Station> searchLists(String name) throws Exception {
        List<Station> stations = repository.findByNameContaining(name);

        return stations;
    }
}
