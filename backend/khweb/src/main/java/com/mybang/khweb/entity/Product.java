package com.mybang.khweb.entity;

import com.mybang.khweb.request.ProductRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long productNo;

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
    // 월세
    @Column
    private String monthlyRent;
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

    public Product(String address, String agentAddress, String agentEmail, double agentLat, double agentLng,
                 String agentMobile, String agentName,  String agentPhone, String buildingType, Long deposit,
                 String description, String elevator, String floor, String floorAll, String image, double lat,
                 double lng, String local1, String local2, String local3, String manageCost, String manageCostInc,
                 String moveinDate, String nearSubways, String options, String parking, String pets, String roomDirection,
                 String roomType, String salesType, String serviceType, String monthlyRent, String size, String sizeM2,
                 String title, String updatedAt, String userIntro, String userName, String url) {
        this.address = address;
        this.agentAddress = agentAddress;
        this.agentEmail = agentEmail;
        this.agentLat = agentLat;
        this.agentLng = agentLng;
        this.agentMobile = agentMobile;
        this.agentName = agentName;
        this.agentPhone = agentPhone;
        this.buildingType = buildingType;
        this.deposit = deposit;
        this.description = description;
        this.elevator = elevator;
        this.floor = floor;
        this.floorAll = floorAll;
        this.image = image;
        this.lat = lat;
        this.lng = lng;
        this.local1 = local1;
        this.local2 = local2;
        this.local3 = local3;
        this.manageCost = manageCost;
        this.manageCostInc = manageCostInc;
        this.moveinDate = moveinDate;
        this.nearSubways = nearSubways;
        this.options = options;
        this.parking = parking;
        this.pets = pets;
        this.roomDirection = roomDirection;
        this.roomType = roomType;
        this.salesType = salesType;
        this.serviceType = serviceType;
        this.size = size;
        this.sizeM2 = sizeM2;
        this.title = title;
        this.updatedAt = updatedAt;
        this.userIntro = userIntro;
        this.userName = userName;
        this.url = url;
        this.monthlyRent = monthlyRent;
    }

    public void updateProduct(ProductRequest request) {
        this.address = request.getAddress();
        this.agentAddress = request.getAgentAddress();
        this.agentEmail = request.getAgentEmail();
        this.agentLat = request.getAgentLat();
        this.agentLng = request.getAgentLng();
        this.agentMobile = request.getAgentMobile();
        this.agentName = request.getAgentName();
        this.agentPhone = request.getAgentPhone();
        this.buildingType = request.getBuildingType();
        this.deposit = request.getDeposit();
        this.description = request.getDescription();
        this.elevator = request.getElevator();
        this.floor = request.getFloor();
        this.floorAll = request.getFloorAll();
        this.image = request.getImage();
        this.lat = request.getLat();
        this.lng = request.getLng();
        this.local1 = request.getLocal1();
        this.local2 = request.getLocal2();
        this.local3 = request.getLocal3();
        this.manageCost = request.getManageCost();
        this.manageCostInc = request.getManageCostInc();
        this.moveinDate = request.getMoveinDate();
        this.nearSubways = request.getNearSubways();
        this.options = request.getOptions();
        this.parking = request.getParking();
        this.pets = request.getPets();
        this.roomDirection = request.getRoomDirection();
        this.roomType = request.getRoomType();
        this.salesType = request.getSalesType();
        this.serviceType = request.getServiceType();
        this.size = request.getSize();
        this.sizeM2 = request.getSizeM2();
        this.title = request.getTitle();
        this.updatedAt = request.getUpdatedAt();
        this.userIntro = request.getUserIntro();
        this.userName = request.getUserName();
        this.url = request.getUrl();
        this.monthlyRent = request.getMonthlyRent();
    }
}
