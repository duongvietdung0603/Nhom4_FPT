package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.model.HoaDon;
import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import com.DungDV13.ApiCinemaFpt.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    public void save(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }

    public List<HoaDon> findAll() {
        return hoaDonRepository.findAll();
    }

    public HoaDon findById(Long id) {
        return hoaDonRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long id) {
        hoaDonRepository.deleteById(id);
    }

}
