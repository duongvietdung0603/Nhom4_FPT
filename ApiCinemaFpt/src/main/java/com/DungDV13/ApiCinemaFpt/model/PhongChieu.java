package com.DungDV13.ApiCinemaFpt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Phongchieu")
public class PhongChieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "phongChieu", cascade = CascadeType.ALL)
    private List<LichChieu> lichChieus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhongChieu() {
    }

    public PhongChieu(String name) {
        this.name = name;
    }
}
