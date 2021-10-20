package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.RoomMate;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.repository.RoomMateRepository;
import com.mybang.khweb.request.RoomMateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMateService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoomMateRepository roomMateRepository;

    // 게시글 등록
    public RoomMate create(RoomMateDto roomMateDto) {
        Member member = memberRepository.findById(roomMateDto.writer).orElse(null);

        RoomMate roomMate = RoomMate.builder()
                                .title(roomMateDto.title)
                                .content(roomMateDto.content)
                                .writer(roomMateDto.writer)
                                .writerName(member.getName())
                                .count(1)
                                .build();

        roomMateRepository.save(roomMate);
        return roomMate;

    }
}
