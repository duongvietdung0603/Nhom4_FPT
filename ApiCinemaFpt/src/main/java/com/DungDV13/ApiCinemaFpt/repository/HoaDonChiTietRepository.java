package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.model.HoaDonChiTiet;
import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {
    @Query("SELECT ct FROM HoaDonChiTiet ct where ct.lichChieu.id = ?1 and ct.viTriGhe = ?2")
    HoaDonChiTiet kiemTraViTriGhe(long idLichChieu,String viTriGhe);

    @Query("SELECT ct.viTriGhe FROM HoaDonChiTiet ct where ct.lichChieu.id = ?1")
    List<String> viTriGheDaDuocChon(long idLichChieu);


    @Query("SELECT m.name, lc.ngayChieu, lc.gioChieu, pc.name, hd.tongTien, u.username FROM HoaDonChiTiet ct, HoaDon hd, User u, LichChieu lc, PhongChieu pc, Movice m where u.username = ?1")
    List<Object> danhsachdadatlich(String idUser);

    List<HoaDonChiTiet> findByHoaDonId(Long id);

    List<HoaDonChiTiet> findByLichChieuId(Long id);
}
