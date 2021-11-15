package com.mybang.khweb.controller;

import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.request.RoomMateResponse;
import com.mybang.khweb.service.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roomMate")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RoomMateController {
    @Autowired
    private RoomMateService roomMateService;

    /**
     * 게시글 등록
     * @param roomMateDto
     * @return
     */
    @PostMapping("/create")
    public RoomMateResponse<RoomMate> create(@RequestBody RoomMateDto roomMateDto) {
        RoomMateResponse<RoomMate> response = new RoomMateResponse<>();
        RoomMate roomMate = roomMateService.create(roomMateDto);
        response.setData(roomMate);
        return response;
    }

    /**
     * 게시글 목록
     * @return
     */
    @GetMapping("/list")
    public RoomMateResponse<List<RoomMate>> findAllRoomMate() {
        RoomMateResponse<List<RoomMate>> response = new RoomMateResponse<>();
        List<RoomMate> roomMateList = roomMateService.findAllRoomMate();
        response.setData(roomMateList);
        return response;
    }

    /**
     * 게시글 읽기
     * @return
     */
    @GetMapping("/{id}")
    public RoomMateResponse<RoomMate> findById(@PathVariable("id") Long id) {
        RoomMateResponse<RoomMate> response = new RoomMateResponse<>();
//        RoomMate roomMate = roomMateService.findById();
        RoomMate roomMate = roomMateService.findById(id);
        response.setData(roomMate);
        return response;
    }


//    /**
//     * 게시글 수정
//     * @param boardNo
//     * @param roomMateDto
//     * @return
//     */
//    @PostMapping("/update/{boardNo}")
//    public RoomMateResponse<RoomMate> update(@PathVariable long boardNo, @RequestBody RoomMateDto roomMateDto) {
//        RoomMateResponse<RoomMate> response = new RoomMateResponse<>();
//        RoomMate roomMate = roomMateService.update(boardNo, roomMateDto);
//        response.setData(roomMate);
//        return response;
//    }
//
//    /**
//     * 게시글 조회
//     * @param boardNo
//     * @return
//     */
//    @GetMapping("/{boardNo}")
//    public RoomMateResponse<Map<String, Object>> getBoard(@PathVariable long boardNo) {
//        RoomMateResponse<Map<String, Object>> response = new RoomMateResponse<>();
//        RoomMate roomMate = roomMateService.get(boardNo);
//        Map<String, Object> map = new HashMap<>();
//        map.put("roomMate", roomMate);
//        response.setData(map);
//        return response;
//    }
//
//    /**
//     * 게시글 삭제
//     * @param boardNo
//     * @return
//     */
//    @DeleteMapping("/delete/{boardNo}")
//    public RoomMateResponse<Boolean> delete(@PathVariable long boardNo) {
//        RoomMateResponse<Boolean> response = new RoomMateResponse<>();
//        Boolean boo = roomMateService.delete(boardNo);
//        response.setData(boo);
//        return response;
//    }
}
