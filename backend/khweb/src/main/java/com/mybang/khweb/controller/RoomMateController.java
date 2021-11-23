package com.mybang.khweb.controller;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.request.ProductRequest;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.request.RoomMateResponse;
import com.mybang.khweb.service.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<RoomMate> create(@RequestBody RoomMateDto roomMateDto) throws Exception {
//        ResponseEntity<RoomMate> response = new ResponseEntity<>();
        RoomMate roomMate = roomMateService.create(roomMateDto);
//        roomMate.create(roomMateDto);
        return new ResponseEntity<RoomMate>(roomMate,HttpStatus.OK);
    }


    /**
     * 게시글 목록
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<RoomMate>> findAllRoomMate() throws Exception {
//        RoomMateResponse<List<RoomMate>> response = new RoomMateResponse<>();
        List<RoomMate> roomMateList = roomMateService.findAllRoomMate();
//        response.setData(roomMateList);
        return new ResponseEntity<List<RoomMate>>(roomMateList,HttpStatus.OK);
    }

    /**
     * 게시글 읽기
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoomMate> findById(@PathVariable("id") Long id) throws Exception {
//        RoomMateResponse<RoomMate> response = new RoomMateResponse<>();
//        RoomMate roomMate = roomMateService.findById();
        RoomMate roomMate = roomMateService.findById(id);
//        response.setData(roomMate);
        return new ResponseEntity<RoomMate>(roomMate, HttpStatus.OK);
    }




    /**
     * 게시글 수정
     * @param id
     * @param roomMateDto
     * @return
     */
    @PostMapping("/update/{id}")
    public ResponseEntity<RoomMate> update(@PathVariable long id, @RequestBody RoomMateDto roomMateDto) throws Exception {
//        RoomMateResponse<RoomMate> response = new RoomMateResponse<>();
        RoomMate roomMate = roomMateService.update(id, roomMateDto);
//        response.setData(roomMate);
        return new ResponseEntity<RoomMate>(roomMate, HttpStatus.OK);
    }
//


    /**
     * 게시글 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoomMate> delete(@PathVariable long id) throws Exception {
//        RoomMateResponse<Boolean> response = new RoomMateResponse<>();
        Boolean boo = roomMateService.delete(id);
//        response.setData(boo);
        return new ResponseEntity<RoomMate>(HttpStatus.OK);
    }
}
