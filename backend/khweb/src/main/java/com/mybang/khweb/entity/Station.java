package com.mybang.khweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long no;

    @Column
    private String code;

    @Column
    private String line;

    @Column
    private String name;

    @Column
    private String lat;

    @Column
    private String lng;

}
