package com.mybang.khweb.service;

import com.mybang.khweb.entity.Station;

import java.util.List;

public interface StationService {
    List<Station> lists() throws Exception;
    List<Station> searchLists(String name) throws Exception;
}
