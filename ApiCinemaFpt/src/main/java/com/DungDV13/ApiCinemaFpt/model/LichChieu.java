package com.DungDV13.ApiCinemaFpt.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Lichchieu")
public class LichChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private java.util.Date ngayChieu;
    private String gioChieu;


    private int price;
    private int status; // suat chieu som = 1 , muộn = 0

    @OneToOne
    @JoinColumn(name = "movice_id", nullable = false)
    private Movice movice ;

    @OneToOne
    @JoinColumn(name = "phongChieu_id", nullable = false)
    private PhongChieu phongChieu;


    @OneToMany(mappedBy = "lichChieu", cascade = CascadeType.ALL)
    private List<HoaDonChiTiet> hoaDonChiTiets;


    public LichChieu(Date ngayChieu, String gioChieu, int price, int status, Movice movice) {
        super();
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.price = price;
        this.status = status;
        this.movice = movice;
    }

    public LichChieu(Date ngayChieu, String gioChieu, int price, int status, Movice movice, PhongChieu phongChieu) {
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.price = price;
        this.status = status;
        this.movice = movice;
        this.phongChieu = phongChieu;
    }

    public Movice getMovice() {
        return movice;
    }



    public void setMovice(Movice movice) {
        this.movice = movice;
    }



    public String getGioChieu() {
        return gioChieu;
    }



    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }



    public java.util.Date getNgayChieu() {
        return ngayChieu;
    }



    public void setNgayChieu(java.util.Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }




    public LichChieu() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }



}
