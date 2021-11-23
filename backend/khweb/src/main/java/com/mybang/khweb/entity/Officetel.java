package com.mybang.khweb.entity;

import com.mybang.khweb.request.OfficetelRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Officetel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long officetelNo;
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
    @Column
    private String agentId;

    public Officetel(String address, String agentAddress, String agentEmail, double agentLat, double agentLng,
                 String agentMobile, String agentName,  String agentPhone, String buildingType, Long deposit,
                 String description, String elevator, String floor, String floorAll, String image, double lat,
                 double lng, String local1, String local2, String local3, String manageCost, String manageCostInc,
                 String moveinDate, String nearSubways, String options, String parking, String pets, String roomDirection,
                 String roomType, String salesType, String serviceType, String size, String sizeM2,
                 String title, String updatedAt, String userIntro, String userName, String url, String agentId) {
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
        this.agentId = agentId;
    }

    public void updateOfficetel(OfficetelRequest request) {
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
        this.agentId = request.getAgentId();
    }
}
