package com.mybang.khweb.service;

import com.mybang.khweb.entity.Officetel;
import com.mybang.khweb.request.OfficetelRequest;

import java.util.List;
import java.util.Optional;

public interface OfficetelService {

    public void register(OfficetelRequest request) throws Exception;

    List<Officetel> lists() throws Exception;

    Optional<Officetel> read(Long officetelNo) throws Exception;

    public void remove(Long officetelNo) throws Exception;

    public void modify(Officetel officetel, OfficetelRequest request) throws Exception;

    List<Officetel> agentList(String agnetId) throws Exception;
}
