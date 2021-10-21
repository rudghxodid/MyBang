package com.mybang.khweb.service;

//import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.entity.Member;
import com.mybang.khweb.entity.MemberAuth;
import com.mybang.khweb.repository.MemberAuthRepository;
import com.mybang.khweb.repository.MemberRepository;
import com.mybang.khweb.request.MemberDto;
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
    private MemberRepository repository;

    @Autowired
    private MemberAuthRepository authRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = encoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(), memberRequest.getEmail(),
                memberRequest.getName(),memberRequest.getBirth(), memberRequest.getSex(), memberRequest.getPhone());
        memberEntity.addAuth(authEntity);

        repository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = repository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!encoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                authRepository.findByMemberNo(loginMember.getMemberNo());

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
        Optional<Member> maybeMember = repository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkDuplicateId(String userId) throws Exception {
        Optional<Member> checkmember = repository.findByUserId(userId);
        if (checkmember == null) {
            log.info("가입가능한 아이디입니다");

            return false;
        }
        return true;

    }
    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return repository.findByAuth(memberNo);
    }


    // -- 회원정보 확인, 수정, 탈퇴, 아이디찾기, 비밀번호찾기(변경) --

    @Override
    public Boolean checkId(String userId) throws Exception {
        Optional<Member> maybeUser = repository.findByUserId(userId);

        if (maybeUser.isPresent()) {
            log.info("already user");
            return false;
        }

        return true;
    }

    @Override
    public Boolean checkPassword(MemberDto memberDto) throws Exception {
        Optional<Member> checkMember = repository.findByUserId(memberDto.getUserId());

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
        return repository.findByUserId(userId);
    }

    @Override
    public Member findById(String userId) throws Exception {
        Member member = repository.findByUserId(userId).orElse(null);

        return member;
    }

    @Override
    public void modify(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        member.modifyMember(memberDto);

        repository.save(member);
    }

    @Override
    public void remove(Member member) throws Exception {
        repository.delete(member);
    }

    @Override
    public Member findByEmail(String email) throws Exception {
        Member member = repository.findByEmail(email).orElse(null);

        return member;
    }

    @Override
    public String findingUserId(MemberDto memberDto) throws Exception {
        Optional<Member> maybeUser = repository.findByEmail(memberDto.getEmail());

        String userId = maybeUser.get().getUserId();

        log.info(userId);

        return userId;
    }

    @Override
    public Boolean findingUser(MemberDto memberDto) throws Exception {
        Optional<Member> maybeUser = repository.findByEmail(memberDto.getEmail());

        String userId = maybeUser.get().getUserId();

        if (!maybeUser.isPresent()) {
            log.info("not find user");
            return false;
        } else if (!userId.equals(memberDto.getUserId())) {
            log.info("not match id");
            return false;
        }

        log.info("success find user");
        return true;
    }

    @Override
    public void modifyPw(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = encoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        member.modifyPassword(memberDto);

        repository.save(member);
    }
}
