package com.mybang.khweb.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {
    private String title; //간단한 설명
    private String image;
    private String description; // 상세설명
    private String deposit; //보증금
    private String price; // 가격
    private String agent_name; //중개사무소+중개인이름
    private String agent_mobile; // 중개인 휴대폰 번호
    private String floor; // 층
    private String address; // 주소
    private String size; // 면적(평수)
    private String size_m2; // 면적(제곱미터)
    private String status; // 광고 여부
    private String room_type; // 건물 유형(투룸, 원룸 등등..)
    private String manage_cost_inc; // 옵션 여부
}
