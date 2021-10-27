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


    // 게시글 목록

}
