package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.repository.RoomMateRepository;
import com.mybang.khweb.request.RoomMateDto;
import com.mybang.khweb.request.RoomMateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomMateService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoomMateRepository roomMateRepository;

    // 게시글 등록
    public RoomMate create(RoomMateDto roomMateDto) {
//        Member member = memberRepository.findById(roomMateDto.writer).orElse(null);

        RoomMate roomMate = RoomMate.builder()
                                .title(roomMateDto.title)
                                .content(roomMateDto.content)
                                .writer(roomMateDto.writer)
//                                .writerName(member.getName())
                                .count(1)
                                .build();

        roomMateRepository.save(roomMate);
        return roomMate;
    }


    // 게시글 수정
    public RoomMate update(long boardNo, RoomMateDto roomMateDto) {
        RoomMate roomMate = roomMateRepository.findById(boardNo).orElse(null);
        roomMate.setTitle(roomMateDto.title);
        roomMate.setContent(roomMateDto.content);
        roomMateRepository.save(roomMate);
        return roomMate;
    }

    // 게시글 목록
    public RoomMate get(long boardNo) {
        RoomMate roomMate = roomMateRepository.findById(boardNo).orElse(null);
        Member member = memberRepository.findById(roomMate.getWriter()).orElse(null);
        roomMate.setWriterName(member.getName());

        if (roomMate != null) {
            roomMate.setCount(roomMate.getCount() + 1);
            roomMateRepository.save(roomMate);
        }
        return roomMate;
    }

    // 게시글 삭제
   public Boolean delete(long boardNo) {
        RoomMate roomMate = roomMateRepository.findById(boardNo).orElse(null);
        roomMateRepository.delete(roomMate);
        return true;
    }

}
