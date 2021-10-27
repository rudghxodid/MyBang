package com.mybang.khweb.controller;

import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.request.RoomMateResponse;
import com.mybang.khweb.service.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomMate")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
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

    // 목록
    @GetMapping("/list")
    public List<RoomMateResponse> findAll() {
        return roomMateService.findAll();
    }

    // 게시글 목록
//    @GetMapping("/list")
//    public RoomMateResponse<Page<Object[]>> getRoomMateList(@RequestBody Integer page, @PathVariable Integer size) {
//        RoomMateResponse<Page<Object[]>> response = new RoomMateResponse<>();
//        Page<Object[]> roomMateList = roomMateService.getRoomMateList(PageRequest.of(page - 1, size, Sort.Direction.DESC, "id"));
//        response.setData(roomMateList);
//        return response;
//    }

}
