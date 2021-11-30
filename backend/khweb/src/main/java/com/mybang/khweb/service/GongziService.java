package com.mybang.khweb.service;

import com.mybang.khweb.entity.Gongzi;
import com.mybang.khweb.entity.Product;
import com.mybang.khweb.request.GongziRequest;
import com.mybang.khweb.request.ProductRequest;

import java.util.List;

public interface GongziService {

    public void register(GongziRequest gongzi) throws Exception;

    public List<Gongzi> list() throws Exception;

    public Gongzi read(Long gongziNo) throws Exception;

    public void remove(Long gongziNo) throws Exception;

    public void modify(Gongzi gongzi, GongziRequest request) throws Exception;

    public void view(Long gongziNo, Integer view) throws Exception;

}
