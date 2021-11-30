package com.mybang.khweb.entity.memberRelated;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="liked_product")
public class LikedProduct {   //매물게시판에서 찜한 상품들을 저장할 테이블을 만드는 클래스입니다

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liked_product_no")
    private Long likedProductNo;

    @Column(name = "member_no", nullable = false)
    private Long memberNo;

    @Column(nullable = false)
    private Long villaNo;
}
