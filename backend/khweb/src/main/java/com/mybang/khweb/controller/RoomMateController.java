package com.mybang.khweb.controller;

import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.request.RoomMateResponse;
import com.mybang.khweb.service.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roomMate")
public class RoomMateController {
    @Autowired
    private RoomMateService roomMateService;

    // 게시글 등록
    @PostMapping("/create")
    public RoomMateResponse<RoomMate> create(@RequestBody RoomMateDto roomMateDto) {
        RoomMateResponse<RoomMate> response = new RoomMateResponse<>();
        RoomMate roomMate = roomMateService.create(roomMateDto);
        response.setData(roomMate);
        return response;
    }

}
