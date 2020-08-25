package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.model.PhongChieu;
import com.DungDV13.ApiCinemaFpt.repository.PhongChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongChieuService {
    @Autowired
    PhongChieuRepository rapChieuRepository;


    public void save(PhongChieu rapChieu) {
        rapChieuRepository.save(rapChieu);
    }

    public List<PhongChieu> findAll() {
        return rapChieuRepository.findAll();
    }

    public PhongChieu findById(Long id) {
        return rapChieuRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long id) {
        rapChieuRepository.deleteById(id);
    }


}
