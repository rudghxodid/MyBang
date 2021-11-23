package com.mybang.khweb.service;

import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.request.VillaRequest;

import java.util.List;
import java.util.Optional;

public interface VillaService {

    public void register(VillaRequest request) throws Exception;

    List<Villa> lists() throws Exception;

    Optional<Villa> read(Long villaNo) throws Exception;

    public void remove(Long villaNo) throws Exception;

    public void modify(Villa villa, VillaRequest request) throws Exception;

    List<Villa> agentList(String agentId) throws Exception;
}
