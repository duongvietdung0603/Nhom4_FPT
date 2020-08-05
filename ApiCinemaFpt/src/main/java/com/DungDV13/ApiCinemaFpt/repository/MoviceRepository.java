package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.model.Movice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviceRepository extends JpaRepository<Movice,Long> {
    Page<Movice> findAll(Pageable pageable);
    List<Movice> findAll();

    @Query("SELECT DISTINCT m FROM Movice m, LichChieu l  where m.id = l.movice and  l.status = 1")
    Page<Movice> findSuatChieuSom(Pageable pageable);

    @Query("SELECT DISTINCT m FROM Movice m, LichChieu l where m.id = l.movice and l.status = 0")
    Page<Movice> findSuatChieuBinhThuong(Pageable pageable);

}
