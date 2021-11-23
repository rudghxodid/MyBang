package com.mybang.khweb.service;

import com.mybang.khweb.entity.Oneroom;
import com.mybang.khweb.request.OneroomRequest;

import java.util.List;
import java.util.Optional;

public interface OneroomService {

    public void register(OneroomRequest request) throws Exception;

    List<Oneroom> lists() throws Exception;

    Optional<Oneroom> read(Long oneroomNo) throws Exception;

    public void remove(Long oneroomNo) throws Exception;

    public void modify(Oneroom oneroom, OneroomRequest request) throws Exception;

    List<Oneroom> agentList(String agnetId) throws Exception;
}
