package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.RoomMateComment;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.repository.RoomMateCommentRepository;
import com.mybang.khweb.request.RoomMateCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomMateCommentService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoomMateCommentRepository roomMateCommentRepository;

    // 댓글 등록
    public RoomMateComment create(Long boardNo, RoomMateCommentDto roomMateCommentDto) throws Exception {
        Member member = memberRepository.findById(roomMateCommentDto.writer).orElse(null);

        RoomMateComment roomMateComment = RoomMateComment.builder()
                .boardNo(boardNo)
                .content(roomMateCommentDto.content)
                .member(member)
                .build();
        roomMateCommentRepository.save(roomMateComment);
        return roomMateComment;
    }

    // 댓글 목록
    public List<RoomMateComment> findAllRoomMateComment() {
        return roomMateCommentRepository.findAll();
    }

    // 댓글 수정
    public RoomMateComment update(long commentId, RoomMateCommentDto roomMateCommentDto) {
        RoomMateComment roomMateComment = roomMateCommentRepository.findById(commentId).orElse(null);
        roomMateComment.setContent(roomMateCommentDto.content);
        roomMateCommentRepository.save(roomMateComment);
        return roomMateComment;
    }

    // 댓글 삭제
    public Boolean delete(long commentId) {
        RoomMateComment roomMateComment = roomMateCommentRepository.findById(commentId).orElse(null);
        roomMateCommentRepository.delete(roomMateComment);
        return true;
    }
}
