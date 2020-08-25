package com.DungDV13.ApiCinemaFpt.controller.frontend.Bean;

import java.util.List;

public class DanhSachDatLich {
    private Long idHoaDon;
    private String tenPhim;
    private String ngayChieu;
    private String gioChieu;
    private String phongChieu;
    private String loaiSuatChieu;
    private int soChoNgoi;
    private double tongTien;
    private String ngayDatVe;

    private List<String> danhSachChoNgo;
    private String maQR;



    public DanhSachDatLich() {
    }

    public Long getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Long idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getLoaiSuatChieu() {
        return loaiSuatChieu;
    }

    public void setLoaiSuatChieu(String loaiSuatChieu) {
        this.loaiSuatChieu = loaiSuatChieu;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }

    public String getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(String phongChieu) {
        this.phongChieu = phongChieu;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(String ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public List<String> getDanhSachChoNgo() {
        return danhSachChoNgo;
    }

    public void setDanhSachChoNgo(List<String> danhSachChoNgo) {
        this.danhSachChoNgo = danhSachChoNgo;
    }

    public String getMaQR() {
        return maQR;
    }

    public void setMaQR(String maQR) {
        this.maQR = maQR;
    }
}
