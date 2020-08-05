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

    public HoaDonChiTiet(Long id) {
        this.id = id;
    }

    public HoaDonChiTiet(HoaDon hoaDon, LichChieu lichChieu, String viTriGhe) {
        this.hoaDon = hoaDon;
        this.lichChieu = lichChieu;
        this.viTriGhe = viTriGhe;
    }
}
