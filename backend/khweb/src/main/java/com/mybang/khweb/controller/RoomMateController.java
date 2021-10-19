package com.mybang.khweb.controller;

import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.service.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomMateController {
    @Autowired
    private RoomMateService roomMateService;

    @PostMapping("/create")
    public RoomMate create(@RequestBody RoomMateDto roomMateDto) {

        return roomMateService.create(roomMateDto);

//        RoomMate roomMate = roomMateService.create(roomMateDto);
//        response.setData(roomMate);
//        return response;
    }

}
