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
//
//    @Query("SELECT u.username, m.name, lc.ngay_chieu, lc.gio_chieu, pc.name, hd.tong_tien   FROM api_cinema.hoa_don_chi_tiet  ct\n" +
//            "join hoa_don hd on hd.id = ct.hoa_don_id\n" +
//            "join lichchieu lc on lc.id = ct.lich_chieu_id\n" +
//            "join phongchieu pc on pc.id = lc.phong_chieu_id\n" +
//            "join users u on u.id = hd.user_id\n" +
//            "join movice m on m.id = lc.movice_id")
//    List<HoaDonChiTiet> danhsachdadatlich(String idUser);

    List<HoaDonChiTiet> findByHoaDonId(Long id);
}
