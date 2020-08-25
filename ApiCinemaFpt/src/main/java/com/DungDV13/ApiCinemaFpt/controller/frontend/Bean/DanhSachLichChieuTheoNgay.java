package com.DungDV13.ApiCinemaFpt.controller.frontend.Bean;

import java.util.List;

public class DanhSachLichChieuTheoNgay {
    private String ngayChieu;
    private List<String> gioChieu;

    public DanhSachLichChieuTheoNgay() {
    }

    public DanhSachLichChieuTheoNgay(String ngayChieu, List<String> gioChieu) {
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public List<String> getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(List<String> gioChieu) {
        this.gioChieu = gioChieu;
    }
}
