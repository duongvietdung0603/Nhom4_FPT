package com.DungDV13.ApiCinemaFpt.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Movice")
public class Movice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;

    @Column(name = "content", columnDefinition = "TEXT NOT NULL")
    private String content;

    private float star;
    private String trailer;
    private String image;
    private String thoiLuong;
    private String nuocSX;
    private int namSX;

        @OneToMany(mappedBy = "movice", cascade = CascadeType.ALL)
    private List<LichChieu> lichChieus;

    public Movice() {
    }

    public Movice(String content, String image,int namSX, String name,String nuocSX, float star,String thoiLuong, String title, String trailer ) {
        this.content = content;
        this.image = image;
        this.namSX = namSX;
        this.name = name;
        this.nuocSX = nuocSX;
        this.star = star;
        this.thoiLuong = thoiLuong;
        this.title = title;
        this.trailer = trailer;
    }


    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getNuocSX() {
        return nuocSX;
    }

    public void setNuocSX(String nuocSX) {
        this.nuocSX = nuocSX;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }
}
