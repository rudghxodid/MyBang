package com.mybang.khweb.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer deposit;

    @Column(nullable = false)
    private String agent_name;

    @Column(nullable = false)
    private String agent_mobile;

    @Column(nullable = false)
    private String floor;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Float size;

    @Column(nullable = false)
    private Float size_m2;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String room_type;

    @Column(nullable = false)
    private String manage_cost_inc;

    @Column(nullable = false)
    private String updated_at2;

    @Column(nullable = false)
    private String url;

    public Product(Long id, String title, String description, Integer deposit, String agent_name, String agent_mobile,
                   String floor, String address, Float size, Float size_m2, String status, String room_type,
                   String manage_cost_inc, String updated_at2, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deposit = deposit;
        this.agent_name = agent_name;
        this.agent_mobile = agent_mobile;
        this.floor = floor;
        this.address = address;
        this.size = size;
        this.size_m2 = size_m2;
        this.status = status;
        this.room_type = room_type;
        this.manage_cost_inc = manage_cost_inc;
        this.updated_at2 = updated_at2;
        this.url = url;
    }
}
