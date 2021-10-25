package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.request.MemberDto;
import com.mybang.khweb.request.MemberRequest;

import java.util.Optional;

public interface MemberService {
    public void register(MemberRequest memberRequest) throws Exception;
    public MemberRequest login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String UserId) throws Exception;
    public boolean checkDuplicateId(String UserId) throws Exception;
    public Optional<Member> findByAuth(Long memberNo);
    public MemberRequest list(MemberRequest memberRequest) throws Exception;

    // -- 회원정보 확인, 수정, 탈퇴, 아이디찾기, 비밀번호찾기(변경) --
    Boolean checkPassword(MemberDto memberDto) throws Exception;
    Optional<Member> userInfo(String userId) throws Exception;
    Member findById(String userId) throws Exception;
    void modify(Member member, MemberDto memberDto) throws Exception;
    void remove(Member member) throws Exception;
    Member findByEmail(String email) throws Exception;
    String findingUserId(MemberDto memberDto) throws Exception;
    Boolean findingUser(MemberDto memberDto) throws Exception;
    void modifyPw(Member member, MemberDto memberDto) throws Exception;
}