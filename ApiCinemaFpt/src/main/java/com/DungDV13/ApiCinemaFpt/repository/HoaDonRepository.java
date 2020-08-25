package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    @Query(" SELECT hd FROM HoaDon hd where hd.user.username = ?1")
    List<HoaDon> danhsachdatlich(String username);

    long countByHoaDonChiTietsLichChieuId(Long id);
    List<HoaDon> findByHoaDonChiTietsLichChieuIdAndUserId(Long LC, Long User);

    Optional<HoaDon> findById(Long id);
}
