package com.DungDV13.ApiCinemaFpt.model;

import javax.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "hoaDon_id", nullable = false)
    private HoaDon hoaDon;

    @OneToOne
    @JoinColumn(name = "lichChieu_id", nullable = false)
    private LichChieu lichChieu;

    private String viTriGhe;

    public HoaDonChiTiet(){

    }

    public HoaDonChiTiet(HoaDon hoaDon, LichChieu lichChieu, String viTriGhe) {
        this.hoaDon = hoaDon;
        this.lichChieu = lichChieu;
        this.viTriGhe = viTriGhe;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LichChieu getLichChieu() {
        return lichChieu;
    }

    public void setLichChieu(LichChieu lichChieu) {
        this.lichChieu = lichChieu;
    }

    public String getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(String viTriGhe) {
        this.viTriGhe = viTriGhe;
    }
}
