package com.DungDV13.ApiCinemaFpt.repository;

import com.DungDV13.ApiCinemaFpt.controller.admin.Bean.DoanhThuTheoPhim;
import com.DungDV13.ApiCinemaFpt.model.Movice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviceRepository extends JpaRepository<Movice,Long> {
    Page<Movice> findAll(Pageable pageable);
    List<Movice> findAll();

//    @Query("SELECT new com.DungDV13.ApiCinemaFpt.controller.admin.Bean.DoanhThuTheoPhim(m.name, Sum(hd.tongTien)) FROM Movice m, LichChieu l, HoaDonChiTiet ct, HoaDon hd  group by m.name")
//    List<DoanhThuTheoPhim> doanhThuTheoPhim1();

    @Query("SELECT hd.tongTien FROM Movice m, LichChieu l, HoaDonChiTiet ct, HoaDon hd WHERE m.name= :name")
     List<String> doanhThuTheoPhim(@Param("name") String name);
    // có cái chỗ này mà k được anh ạ, nhưng bữa sau fix sau ạ
    // chỗ nào em?
    // thường thì a se viết như sau
    // gán giá trị name và param name => sau đó :name là lấy giá trị của param name bỏ vào
    // anh chưa thử cách dùng ?1, ?2
    //anh xem qua cái đã, cái này cũng chưa vội lắm, ít bữa em test sau vì hiện tại chưa dùng nó lắm ạ
    // thường query mà có param a hay viết theo kiểu trên á
    // đang nói hàm này phải ko
    // nó trả về k đúng như sql
    // tongTien la 1 double (number) em phai cast về string (varchar) còn làm sao thì a ko biết :D
    // đâu, em test trả về double mà cũng k ddwowjw á
    // chắc để sau :v không đc hay bị lỗi thì cứ tra trên stackoverflow á
    //dạ

    @Query("SELECT DISTINCT m FROM Movice m, LichChieu l  where m.id = l.movice and  l.status = 1")
    Page<Movice> findSuatChieuSom(Pageable pageable);

    @Query("SELECT DISTINCT m FROM Movice m, LichChieu l where m.id = l.movice and l.status = 0")
    Page<Movice> findSuatChieuBinhThuong(Pageable pageable);

    List<Movice> findByStatus(int a);



}
