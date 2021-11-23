package com.mybang.khweb.service;

import com.mybang.khweb.entity.SeoulDong;

import java.util.List;

public interface SeoulDongService {
    List<SeoulDong> lists(String gu) throws Exception;
}
