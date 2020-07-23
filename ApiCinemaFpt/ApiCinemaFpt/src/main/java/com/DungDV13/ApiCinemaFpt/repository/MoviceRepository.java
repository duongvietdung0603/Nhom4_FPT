package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.model.Movice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviceRepository extends JpaRepository<Movice,Long> {
    Page<Movice> findAll(Pageable pageable);

}
