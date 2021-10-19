package com.mybang.khweb.service;

//import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.MemberAuth;
import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.request.MemberRequest;
import lombok.extern.slf4j.Slf4j;
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
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(), memberRequest.getEmail(),
                memberRequest.getName(),memberRequest.getAge(), memberRequest.getSex(), memberRequest.getPhone());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth == null) {
            log.info("auth 없음");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(
                memberRequest.getUserId(),
                memberRequest.getPassword(),
                memberAuth.getAuth());

        return response;
    }

    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkDuplicateId(String userId) throws Exception {
        Optional<Member> checkmember = memberRepository.findByUserId(userId);
        if (checkmember == null) {
            log.info("가입가능한 아이디입니다");

            return false;
        }
        return true;

    }



    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }

}
