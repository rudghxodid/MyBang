package com.mybang.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Villa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long villaNo;
    // 매물주소
    @Column
    private String address;
    // 중개사 주소
    @Column
    private String agentAddress;
    // 중개사 이메일
    @Column
    private String agentEmail;
    // 중개사 주소 좌표값
    @Column
    private double agentLat;
    @Column
    private double agentLng;
    // 중개사 핸드폰
    @Column
    private String agentMobile;
    // 중개사 이름
    @Column
    private String agentName;
    // 중개사 전화
    @Column
    private String agentPhone;
    // 건물 타입
    @Column
    private String buildingType;
    // 전세금(월세 보증금 or 매매금)
    @Column
    private Long deposit;
    //월세
    @Column
    private Long rent;
    // 매물 설명
    @Column(columnDefinition = "text")
    private String description;
    // 엘리베이터 유무
    @Column
    private String elevator;
    // 매물 층
    @Column
    private String floor;
    // 건물 총 층
    @Column
    private String floorAll;
    // 매물 사진
    @Column(columnDefinition = "text")
    private String image;
    // 매물 좌표값
    @Column
    private double lat;
    @Column
    private double lng;
    // 매물 주소 (시)
    @Column
    private String local1;
    // 매물 주소 (구)
    @Column
    private String local2;
    // 매물 주소 (동)
    @Column
    private String local3;
    // 관리비
    @Column
    private String manageCost;
    // 관리비에 포함된 항목(ex) 인터넷, 수도...)
    @Column
    private String manageCostInc;
    // 입주가능날짜
    @Column
    private String moveinDate;
    // 인근 지하철
    @Column
    private String nearSubways;
    // 옵션(ex) 냉장고, 에어컨...)
    @Column(columnDefinition = "text")
    private String options;
    // 주차 가능 여부
    @Column
    private String parking;
    // 애완동물 가능 여부
    @Column
    private String pets;
    // 매물 방향(ex) 남향, 북향..)
    @Column
    private String roomDirection;
    // 매물 타입(ex) 원룸, 투룸..)
    @Column
    private String roomType;
    // 판매 타입(ex) 전세, 월세..)
    @Column
    private String salesType;
    // 서비스 타입(ex) 원룸, 빌라, 아파트..)
    @Column
    private String serviceType;
    // 매물 사이즈(평)
    @Column
    private String size;
    // 매물 사이즈(제곱미터)
    @Column(name = "size_m2")
    private String sizeM2;
    // 매물 제목
    @Column(length = 1000)
    private String title;
    // 매물 업데이트 날짜
    @Column
    private String updatedAt;
    // 중개인 설명
    @Column(columnDefinition = "text")
    private String userIntro;
    // 중개인 이름
    @Column
    private String userName;
    // 매물 url
    @Column
    private String url;

}
