package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import com.DungDV13.ApiCinemaFpt.model.Movice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface LichChieuRepository extends JpaRepository<LichChieu, Long> {
    Page<LichChieu> findAll(Pageable pageable);

    List<LichChieu> findByNgayChieu(Date date);
    List<LichChieu> findByMoviceId(Long id);
    List<LichChieu> findByMoviceIdAndNgayChieuAndStatus(Long id, Date date, Integer suatChieu);
    List<LichChieu> findByMoviceIdAndStatus(Long id, Integer status);

    @Query("SELECT lc FROM LichChieu lc where lc.movice.id = ?1 and lc.ngayChieu = ?2 and lc.gioChieu = ?3 and lc.phongChieu.id = ?4 and lc.status =?5 ")
    LichChieu findLichChieu(long idMovice, Date date, String gioChieu, long phongChieu, int status);

}
