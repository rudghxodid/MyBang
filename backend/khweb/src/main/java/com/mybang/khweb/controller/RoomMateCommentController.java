package com.mybang.khweb.controller;

import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.entity.RoomMateComment;
import com.mybang.khweb.request.RoomMateCommentDto;
import com.mybang.khweb.service.RoomMateCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roomMateComment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RoomMateCommentController {
    @Autowired
    private RoomMateCommentService roomMateCommentService;

    /**
     * 댓글 등록
     * @param id 게시글 번호
     * @param roomMateCommentDto 댓글 Request (내용, 작성자)
     * @return
     */
    @PostMapping("/create/{id}")
    public ResponseEntity<RoomMateComment> create(@RequestBody RoomMateCommentDto roomMateCommentDto, @PathVariable Long id) throws Exception {
        RoomMateComment roomMateComment = roomMateCommentService.create(id, roomMateCommentDto);
        return new ResponseEntity<RoomMateComment>(roomMateComment, HttpStatus.OK);
    }
//
//    // 댓글 목록 (test)
//    @GetMapping("/list")
//    public ResponseEntity<List<RoomMateComment>> findAllRoomMateComment() throws Exception {
//        List<RoomMateComment> roomMateCommentList = roomMateCommentService.findAllRoomMateComment();
//        return new ResponseEntity<List<RoomMateComment>>(roomMateCommentList,HttpStatus.OK);
//    }

    // 댓글 수정
    @PostMapping("/update/{commentId}")
    public ResponseEntity<RoomMateComment> update(@PathVariable long commentId, @RequestBody RoomMateCommentDto roomMateCommentDto) throws Exception {
        RoomMateComment roomMateComment = roomMateCommentService.update(commentId, roomMateCommentDto);
        return new ResponseEntity<RoomMateComment>(roomMateComment, HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<RoomMateComment> delete(@PathVariable long commentId) throws Exception {
        Boolean boo = roomMateCommentService.delete(commentId);
        return new ResponseEntity<RoomMateComment>(HttpStatus.OK);
    }
}