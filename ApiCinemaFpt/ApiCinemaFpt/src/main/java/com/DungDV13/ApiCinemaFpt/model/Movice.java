package com.DungDV13.ApiCinemaFpt.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Movice")
public class Movice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String content;
    private String trailer;
    private String image;
    private String thoiLuong;
    private String nuocSX;
    private int namSX;

    public Movice() {
    }

    public Movice( String name, String title, String content, String trailer, String image, String thoiLuong, String nuocSX, int namSX) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.trailer = trailer;
        this.image = image;
        this.thoiLuong = thoiLuong;
        this.nuocSX = nuocSX;
        this.namSX = namSX;
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
