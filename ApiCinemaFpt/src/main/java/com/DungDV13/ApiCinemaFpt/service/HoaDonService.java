package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.model.HoaDon;
import com.DungDV13.ApiCinemaFpt.model.HoaDonChiTiet;
import com.DungDV13.ApiCinemaFpt.model.User;
import com.DungDV13.ApiCinemaFpt.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<HoaDon> danhsachdatlich(String username) {
        return hoaDonRepository.danhsachdatlich(username);
    }

    public Long countByHoaDonChiTietsLichChieuId(Long id) {
        return hoaDonRepository.countByHoaDonChiTietsLichChieuId(id);
    }

    public List<HoaDon> findByHoaDonChiTietsLichChieuIdAndUserId(Long id, Long user) {
        return hoaDonRepository.findByHoaDonChiTietsLichChieuIdAndUserId(id, user);
    }

}
