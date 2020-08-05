package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.model.HoaDon;
import com.DungDV13.ApiCinemaFpt.model.HoaDonChiTiet;
import com.DungDV13.ApiCinemaFpt.repository.HoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    public void save(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public List<HoaDonChiTiet> findAll() {
        return hoaDonChiTietRepository.findAll();
    }

    public HoaDonChiTiet findById(Long id) {
        return hoaDonChiTietRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long id) {
        hoaDonChiTietRepository.deleteById(id);
    }

    public HoaDonChiTiet kiemTraViTriGhe(Long id, String viTriGhe) {
        return hoaDonChiTietRepository.kiemTraViTriGhe(id, viTriGhe);
    }
}
