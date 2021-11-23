package com.mybang.khweb.entity;


import com.mybang.khweb.request.GongziRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="gongzi")


public class Gongzi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gongzi_no", nullable = false)
    private Long gongziNo;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(length = 1000, nullable = false)
    private String description;


    public Gongzi(String title, String writer, String description) {
        this.title = title;
        this.writer = writer;
        this.description = description;

    }

    public void updateGongzi(GongziRequest request) {
        this.title = request.getTitle();
        this.writer = request.getWriter();
        this.description = request.getDescription();

    }
}
