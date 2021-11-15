package com.mybang.khweb.service;

import com.mybang.khweb.entity.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {
    List<Station> lists() throws Exception;
    List<Station> searchLists(String name) throws Exception;
}
