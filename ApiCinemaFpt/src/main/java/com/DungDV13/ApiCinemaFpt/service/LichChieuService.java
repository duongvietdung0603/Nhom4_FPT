package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.controller.frontend.Bean.DanhSachLichChieuTheoNgay;
import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.repository.LichChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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


    //tìm lịch chiếu theo phim và trạng thái
    public Set<DanhSachLichChieuTheoNgay> danhSachLichChieuTheoNgay(long id, int status){

        List<DanhSachLichChieuTheoNgay> danhSachLichChieuTheoNgays = new ArrayList<>();

        List<LichChieu> lichChieu = lichChieuRepository.findByMoviceIdAndStatus(id,status);

        for (int i = 0; i < lichChieu.size(); i++) {

            DanhSachLichChieuTheoNgay itemDanhSach = new DanhSachLichChieuTheoNgay();
            List<String> danhSachGio = new ArrayList<>();

            itemDanhSach.setNgayChieu(String.valueOf(lichChieu.get(i).getNgayChieu()));
            danhSachGio.add(lichChieu.get(i).getGioChieu());
            for (int j = i+1; j < lichChieu.size(); j++) {
                if(String.valueOf(lichChieu.get(i).getNgayChieu()).equals(String.valueOf(lichChieu.get(j).getNgayChieu()))){
                    danhSachGio.add(lichChieu.get(j).getGioChieu());
                }
            }
            //loại bỏ thời gian trùng nhau
            List<String> newDanhSachGio =danhSachGio
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());

            itemDanhSach.setGioChieu(newDanhSachGio);
            danhSachLichChieuTheoNgays.add(itemDanhSach);
        }

        //loại bỏ đối tượng có ngày giống nhau trong list
        Set<DanhSachLichChieuTheoNgay> result2 = danhSachLichChieuTheoNgays.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(DanhSachLichChieuTheoNgay::getNgayChieu))));

        return result2;
    }


    //tìm lịch chiếu theo phim, ngày, giờ chiếu và trạng thái
    public LichChieu findLichChieu(long idMovice, Date date, String gioChieu, long phongChieu, int status) {
        return lichChieuRepository.findLichChieu(idMovice,date,gioChieu,phongChieu,status);
    }


    //tìm lịch chiếu theo phim, ngày chiếu và suất chiếu
    public List<String> findByMoviceIdAndNgayChieuAndStatus(long idMovice, Date idNgay, Integer suat) {
        List<LichChieu> lichChieus = lichChieuRepository.findByMoviceIdAndNgayChieuAndStatus(idMovice, idNgay,suat);
        List<String> gioChieu = new ArrayList<>();

        lichChieus.forEach((element) -> {
            gioChieu.add(element.getGioChieu());
        });

        List<String> newGioChieu =gioChieu
                .stream()
                .distinct()
                .collect(Collectors.toList());


        return newGioChieu;
    }

    //tìm lịch chiếu theo phim
    public List<String> findByMoviceId(Long id){
        List<LichChieu> lichChieus = lichChieuRepository.findByMoviceId(id);
        List<String> ngayChieu = new ArrayList<>();

        lichChieus.forEach((element) -> {
            if(element.getStatus()==0){
                String ngay = String.valueOf(element.getNgayChieu());
                ngayChieu.add(ngay);
            }else {
                String ngay = element.getNgayChieu() + " - suất chiếu sớm";
                ngayChieu.add(ngay);
            }
        });

        List<String> newNgayChieu =ngayChieu
                .stream()
                .distinct()
                .collect(Collectors.toList());

        return newNgayChieu;
    }
}
