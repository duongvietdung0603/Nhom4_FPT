package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.model.HoaDonChiTiet;
import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {



    @Query("SELECT ct FROM HoaDonChiTiet ct where ct.lichChieu.id = ?1 and ct.viTriGhe = ?2")
    HoaDonChiTiet kiemTraViTriGhe(long idLichChieu,String viTriGhe);
}
