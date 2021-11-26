package com.mybang.khweb.controller;

import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.entity.RoomMateComment;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.service.RoomMateCommentService;
import com.mybang.khweb.service.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomMate")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RoomMateController {
    @Autowired
    private RoomMateService roomMateService;

    @Autowired
    private RoomMateCommentService roomMateCommentService;

    /**
     * 게시글 등록
     * @param roomMateDto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<RoomMate> create(@RequestBody RoomMateDto roomMateDto) throws Exception {
        RoomMate roomMate = roomMateService.create(roomMateDto);
        return new ResponseEntity<RoomMate>(roomMate,HttpStatus.OK);
    }


    /**
     * 게시글 목록
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<RoomMate>> findAllRoomMate() throws Exception {
        List<RoomMate> roomMateList = roomMateService.findAllRoomMate();
        return new ResponseEntity<List<RoomMate>>(roomMateList,HttpStatus.OK);
    }

    /**
     * 게시글 읽기
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoomMate> findById(@PathVariable("id") Long id) throws Exception {
        RoomMate roomMate = roomMateService.findById(id);

//        List<RoomMateComment> roomMateComments = roomMateCommentService.findAllRoomMateComment();
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
        RoomMate roomMate = roomMateService.update(id, roomMateDto);
        return new ResponseEntity<RoomMate>(roomMate, HttpStatus.OK);
    }

    /**
     * 게시글 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoomMate> delete(@PathVariable long id) throws Exception {
        Boolean boo = roomMateService.delete(id);
        return new ResponseEntity<RoomMate>(HttpStatus.OK);
    }
}
