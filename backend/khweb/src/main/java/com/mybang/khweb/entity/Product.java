package com.mybang.khweb.entity;


import com.mybang.khweb.request.ProductRequest;
import lombok.Builder;
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
    @Column(name = "product_no", nullable = false)
    private Long productNo;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(nullable = false)
    private String deposit;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String agent_name;

    @Column(nullable = false)
    private String agent_mobile;

    @Column(nullable = false)
    private String floor;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String size_m2;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String room_type;

    @Column(length = 500, nullable = false)
    private String manage_cost_inc;

    public Product(String title, String image, String description,
                   String deposit, String price,  String agent_name, String agent_mobile, String floor,
                   String address, String size, String size_m2, String status, String room_type, String manage_cost_inc) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.deposit = deposit;
        this.price = price;
        this.agent_name = agent_name;
        this.agent_mobile = agent_mobile;
        this.floor = floor;
        this.address = address;
        this.size = size;
        this.size_m2 = size_m2;
        this.status = status;
        this.room_type = room_type;
        this.manage_cost_inc = manage_cost_inc;
    }

    public void updateProduct(ProductRequest request) {
        this.title = request.getTitle();
        this.image = request.getImage();
        this.description = request.getDescription();
        this.deposit = request.getDeposit();
        this.price = request.getPrice();
        this.agent_name = request.getAgent_name();
        this.agent_mobile = request.getAgent_mobile();
        this.floor = request.getFloor();
        this.address = request.getAddress();
        this.size = request.getSize();
        this.size_m2 = request.getSize_m2();
        this.status = request.getStatus();
        this.room_type = request.getRoom_type();
        this.manage_cost_inc = request.getManage_cost_inc();
    }
}
