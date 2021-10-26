package com.mybang.khweb.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {
    private Long id; // 넘버
    private String title; //간단한 설명
    private String description; // 상세설명
    private Integer deposit; //보증금
    private String agent_name; //중개사무소+중개인이름
    private String agent_mobile; // 중개인 휴대폰 번호
    private String floor; // 층
    private String address; // 주소
    private Float size; // 면적(평수)
    private Float size_m2; // 면적(제곱미터)
    private String status; // 광고 여부
    private String room_type; // 건물 유형(투룸, 원룸 등등..)
    private String manage_cost_inc; // 옵션 여부
    private String updated_at2;  // 업로드 일자
    private String url; // 게시물 위치
}
