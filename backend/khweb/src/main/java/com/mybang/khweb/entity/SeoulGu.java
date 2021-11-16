package com.mybang.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SeoulGu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long no;
    @Column
    private String city;
    @Column
    private String gu;
    @Column
    private String lat;
    @Column
    private String lng;
}
