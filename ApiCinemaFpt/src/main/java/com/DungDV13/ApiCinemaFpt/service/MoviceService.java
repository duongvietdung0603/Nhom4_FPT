package com.DungDV13.ApiCinemaFpt.service;


import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.repository.MoviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviceService {
    @Autowired
    MoviceRepository moviceRepository;

    public void save(Movice movice) {
        moviceRepository.save(movice);
    }

    public Page<Movice> findAll(Pageable pageable) {
        return moviceRepository.findAll(pageable);
    }
    public List<Movice> findAll() {
        return moviceRepository.findAll();
    }

    public Movice findById(Long id) {
        return moviceRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long id) {
        moviceRepository.deleteById(id);
    }

    public Page<Movice> findSuatChieuSom(Pageable pageable) {
        return moviceRepository.findSuatChieuSom(pageable);
    }

    public Page<Movice> findSuatChieuBinhThuong(Pageable pageable) {
        return moviceRepository.findSuatChieuBinhThuong(pageable);
    }
}
