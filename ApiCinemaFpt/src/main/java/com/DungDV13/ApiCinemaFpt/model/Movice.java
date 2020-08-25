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
    private String banner;
    private String poster;
    private String thoiLuong;
    private String nuocSX;
    private int namSX;
    private int status; //0 là chưa chiếu, 1 là đang chiếu

        @OneToMany(mappedBy = "movice", cascade = CascadeType.ALL)
    private List<LichChieu> lichChieus;

    public Movice() {
    }

    public Movice(String name, String title, String content, float star, String trailer, String banner, String poster, String thoiLuong, String nuocSX, int namSX, int status) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.star = star;
        this.trailer = trailer;
        this.banner = banner;
        this.poster = poster;
        this.thoiLuong = thoiLuong;
        this.nuocSX = nuocSX;
        this.namSX = namSX;
        this.status = status;
    }

    public Movice(String name, String title, String content, float star, String trailer, String banner, String poster, String thoiLuong, String nuocSX, int namSX) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.star = star;
        this.trailer = trailer;
        this.banner = banner;
        this.poster = poster;
        this.thoiLuong = thoiLuong;
        this.nuocSX = nuocSX;
        this.namSX = namSX;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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
