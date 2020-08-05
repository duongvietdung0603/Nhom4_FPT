package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.repository.LichChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LichChieuService {
    @Autowired
    LichChieuRepository lichChieuRepository;


    public void save(LichChieu lichChieu) {
        lichChieuRepository.save(lichChieu);
    }

    public Page<LichChieu> findAll(Pageable pageable) {
        return lichChieuRepository.findAll(pageable);
    }

    public LichChieu findById(Long id) {
        return lichChieuRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long id) {
        lichChieuRepository.deleteById(id);
    }

    public List<LichChieu> findByNgayChieu(Date date) {
        return lichChieuRepository.findByNgayChieu(date);
    }

    public List<LichChieu> findByMoviceId(long id) {
       return lichChieuRepository.findByMoviceId(id);
    }

    public LichChieu findLichChieu(long idMovice, Date date, String gioChieu, long phongChieu) {
        return lichChieuRepository.findLichChieu(idMovice,date,gioChieu,phongChieu);
    }
}
