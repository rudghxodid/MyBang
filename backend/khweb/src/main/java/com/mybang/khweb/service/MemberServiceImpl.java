package com.mybang.khweb.service;

import com.mybang.khweb.entity.Member;
import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.request.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Lazy
@Slf4j
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberAuthRepository authRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Member signup(MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        Member member = repository.save(memberDto.toEntity());

        return member;
    }

    @Override
    public Boolean checkPassword(MemberDto memberDto) throws Exception {
        Optional<Member> checkMember = repository.findById(memberDto.getUserId());

        String memberPassword = checkMember.get().getPassword();

        if(!encoder.matches(memberDto.getPassword(), memberPassword)) {
            log.info("fail pw");
            return false;
        }

        log.info("success pw");
        return true;
    }

    @Override
    public Optional<Member> userInfo(String userId) throws Exception {
        return repository.findById(userId);
    }

//    @Override
//    public Member findById(String userId) throws Exception {
//        Member member = repository.findById(userId).orElseThrow();
//
//        return member;
//    }

    @Override
    public void modify(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        member.modifyMember(memberDto);

        repository.save(member);
    }
}
