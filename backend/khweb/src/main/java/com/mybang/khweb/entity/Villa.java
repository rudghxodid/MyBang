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
    @Column
    private String address;
    @Column
    private String agentAddress;
    @Column
    private String agentEmail;
    @Column
    private double agentLat;
    @Column
    private double agentLng;
    @Column
    private String agentMobile;
    @Column
    private String agentName;
    @Column
    private String agentPhone;
    @Column
    private String buildingType;
    @Column
    private Long deposit;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    private String elevator;
    @Column
    private String floor;
    @Column
    private String floorAll;
    @Column(columnDefinition = "text")
    private String image;
    @Column
    private double lat;
    @Column
    private double lng;
    @Column
    private String local1;
    @Column
    private String local2;
    @Column
    private String local3;
    @Column
    private String manageCost;
    @Column
    private String manageCostInc;
    @Column
    private String moveinDate;
    @Column
    private String nearSubways;
    @Column(columnDefinition = "text")
    private String options;
    @Column
    private String parking;
    @Column
    private String pets;
    @Column
    private String roomDirection;
    @Column
    private String roomType;
    @Column
    private String salesType;
    @Column
    private String serviceType;
    @Column
    private String size;
    @Column(name = "size_m2")
    private String sizeM2;
    @Column(length = 1000)
    private String title;
    @Column
    private String updatedAt;
    @Column(columnDefinition = "text")
    private String userIntro;
    @Column
    private String userName;
    @Column
    private String url;

}
