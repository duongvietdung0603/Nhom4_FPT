package com.DungDV13.ApiCinemaFpt.controller.admin.Bean;

import java.util.List;

public class DanhSachDatVeTheoLC {
    private String nameUser;
    private String email;
    private String ngayDat;
    private double soLuong;
    private double tongTien;
    private List<String> viTriGhe;

    public DanhSachDatVeTheoLC() {
    }

    public List<String> getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(List<String> viTriGhe) {
        this.viTriGhe = viTriGhe;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
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
}
