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

    private double tongTien;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<HoaDonChiTiet> hoaDonChiTiets;


    public HoaDon(Long id) {
        this.id = id;
    }

    public HoaDon(Date ngaDat, double tongTien, User user) {
        this.ngaDat = ngaDat;
        this.tongTien = tongTien;
        this.user = user;
    }

    public Date getNgaDat() {
        return ngaDat;
    }

    public void setNgaDat(Date ngaDat) {
        this.ngaDat = ngaDat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
