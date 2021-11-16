package com.mybang.khweb.service;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Villa;
import com.mybang.khweb.request.VillaRequest;

import java.util.List;

public interface VillaService {

    public void register(VillaRequest request) throws Exception;

    List<Villa> lists() throws Exception;

    public Villa read(Long villaNo) throws Exception;
}
