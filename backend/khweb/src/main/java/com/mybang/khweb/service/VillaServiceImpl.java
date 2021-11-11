package com.mybang.khweb.service;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.repository.VillaRepository;
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

        Villa villaEntity = new Villa(request.getAddress(), request.getAgentAddress(), request.getAgentEmail(),
                request.getAgentLat(), request.getAgentLng(), request.getAgentMobile(), request.getAgentName(),
                request.getAgentPhone(), request.getBuildingType(), request.getDeposit(), request.getDescription(),
                request.getElevator(), request.getFloor(), request.getFloorAll(), request.getImage(), request.getLat(),
                request.getLng(), request.getLocal1(), request.getLocal2(), request.getLocal3(), request.getManageCost(),
                request.getManageCostInc(), request.getMoveinDate(), request.getNearSubways(), request.getOptions(),
                request.getParking(), request.getPets(), request.getRoomDirection(), request.getRoomType(), request.getSalesType(),
                request.getServiceType(), request.getSize(), request.getSizeM2(), request.getTitle(), request.getUpdatedAt(),
                request.getUserIntro(), request.getUserName(), request.getUrl());

        repository.save(villaEntity);

    }

    @Override
    public List<Villa> lists() throws Exception {
        List<Villa> villas = repository.findAll();

        return villas;
    }

    @Override
    public Villa read(Long villaNo) throws Exception {

        Optional<Villa> villaRead = repository.findByVilla(villaNo);

        return villaRead.get();
    }
}
