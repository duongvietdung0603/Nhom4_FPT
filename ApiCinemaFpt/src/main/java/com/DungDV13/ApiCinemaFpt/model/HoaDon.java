package com.DungDV13.ApiCinemaFpt.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private java.util.Date ngaDat;

    private double soLuong;
    private double tongTien;

    // tạo mã QR để check vé
    private String maQR;

    //liên kết 1-1
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //liên kết 1-n
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<HoaDonChiTiet> hoaDonChiTiets;

    public HoaDon() {
    }

    public User getUser() {
        return user;
    }

    public HoaDon(Date ngaDat, double tongTien, User user) {
        this.ngaDat = ngaDat;
        this.tongTien = tongTien;
        this.user = user;
    }

    public HoaDon(Date ngaDat, double soLuong, double tongTien, String maQR, User user) {
        this.ngaDat = ngaDat;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.maQR = maQR;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgaDat() {
        return ngaDat;
    }

    public void setNgaDat(Date ngaDat) {
        this.ngaDat = ngaDat;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaQR() {
        return maQR;
    }

    public void setMaQR(String maQR) {
        this.maQR = maQR;
    }

}
