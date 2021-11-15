package com.mybang.khweb.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {
    private String address;
    private String agentAddress;
    private String agentEmail;
    private double agentLat;
    private double agentLng;
    private String agentMobile;
    private String agentName;
    private String agentPhone;
    private String buildingType;
    private Long deposit;
    private String description;
    private String elevator;
    private String floor;
    private String floorAll;
    private String image;
    private double lat;
    private double lng;
    private String local1;
    private String local2;
    private String local3;
    private String manageCost;
    private String manageCostInc;
    private String moveinDate;
    private String nearSubways;
    private String options;
    private String parking;
    private String pets;
    private String roomDirection;
    private String roomType;
    private String salesType;
    private String serviceType;
    private String size;
    private String sizeM2;
    private String title;
    private String updatedAt;
    private String userIntro;
    private String userName;
    private String url;
    private String monthlyRent;
}
