package com.mybang.khweb.entity;

import com.mybang.khweb.entity.memberRelated.LikedProduct;
import com.mybang.khweb.request.MemberDto;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true) 찜하기 기능때문에 적어놓음
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = true)
    private int pause = 0;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public Member(String userId, String password, String email, String name, String birth, String sex, String phone, int pause) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.pause = pause;
    }

    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }

    // 회원정보 변경
    public void modifyMember(MemberDto memberDto) {
        this.password = memberDto.getPassword();
        this.email = memberDto.getEmail();
        this.phone = memberDto.getPhone();
    }

    // 비밀번호 재설정
    public void modifyPassword(MemberDto memberDto) {
        this.password = memberDto.getPassword();
    }

    // 찜하기
    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "member_no")
    private List<LikedProduct> likedProducts = new ArrayList<LikedProduct>();

    public void removeLikedList(List<LikedProduct> list) {
        this.likedProducts.remove(list);
    }

     */
}