package com.DungDV13.ApiCinemaFpt.controller.frontend;

import java.text.ParseException;
import java.util.*;


import com.DungDV13.ApiCinemaFpt.model.*;
import com.DungDV13.ApiCinemaFpt.repository.PhongChieuRepository;
import com.DungDV13.ApiCinemaFpt.repository.RoleRepository;
import com.DungDV13.ApiCinemaFpt.service.HoaDonChiTietService;
import com.DungDV13.ApiCinemaFpt.service.HoaDonService;
import com.DungDV13.ApiCinemaFpt.service.LichChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;

import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping("api/lichchieu/")
public class LichChieuController {



    @Autowired
    LichChieuService lichChieuService;
    @Autowired
    PhongChieuRepository rapChieuRepository;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    RoleRepository roleRepository;




    @GetMapping("/getAll")
    public ResponseEntity<Page<LichChieu>> getAll(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "5", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<Page<LichChieu>>(lichChieuService.findAll(pageable), HttpStatus.OK);
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<LichChieu> getById(@PathVariable long id) {
        return new ResponseEntity<LichChieu>(lichChieuService.findById(id), HttpStatus.OK);
    }



    @PostMapping("/insert")
    public ResponseEntity<String> insert(@Validated @RequestBody LichChieu lichChieu) {
        lichChieuService.save(lichChieu);
        return ResponseEntity.ok().body("OK! insert successfully!");
    }



    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @Validated @RequestBody LichChieu lichChieu) {
        lichChieu.setId(id);
        lichChieuService.save(lichChieu);
        return ResponseEntity.ok().body("OK! update successfully!");
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        lichChieuService.deleteById(id);
        return ResponseEntity.ok().body("OK! delete successfully!");
    }

    @GetMapping("/getByNgayChieu/{ngay}")
    public ResponseEntity<List<LichChieu>> delete(@PathVariable String ngay) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
        System.out.println("ngafy can tim: "+date);
        return new ResponseEntity<List<LichChieu>>(lichChieuService.findByNgayChieu(date), HttpStatus.OK);
    }

//    @GetMapping("/getByMovice/{id}")
//    public ResponseEntity<List<LichChieu>> getByMovice(@PathVariable long id) {
//        return new ResponseEntity<List<LichChieu>>(lichChieuService.findByMoviceId(id), HttpStatus.OK);
//    }

    @GetMapping("/findLichChieu/{idMovice}/{ngayChieu}/{gioChieu}/{phongChieu}/{status}")
    public ResponseEntity<LichChieu> findLichChieu(@PathVariable long idMovice,
                                                         @PathVariable String ngayChieu,
                                                         @PathVariable String gioChieu,
                                                        @PathVariable long phongChieu,
                                                        @PathVariable int status
                                                         ) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(ngayChieu);
        return new ResponseEntity<>(lichChieuService.findLichChieu(idMovice, date, gioChieu, phongChieu,status), HttpStatus.OK);
    }

    @GetMapping("/viTriGheDaDuocChon/{idLich}")
    public ResponseEntity<List<String>> viTriGheDaDuocChon(@PathVariable long idLich)  {
        return new ResponseEntity<>(hoaDonChiTietService.viTriGheDaDuocChon(idLich), HttpStatus.OK);
    }


    @GetMapping("/danhSachLichChieuTheoNgay/{status}/{idMovice}")
    public ResponseEntity<Set<DanhSachLichChieuTheoNgay>> test(@PathVariable long idMovice, @PathVariable int status )  {

        List<DanhSachLichChieuTheoNgay> danhSachLichChieuTheoNgays = new ArrayList<>();

        List<LichChieu> lichChieu = lichChieuService.findByMoviceIdAndStatus(idMovice,status);

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

        return new ResponseEntity<>(result2,HttpStatus.OK);
    }



}



class DanhSachLichChieuTheoNgay {
    private String ngayChieu;
    private List<String> gioChieu;

    public DanhSachLichChieuTheoNgay() {
    }

    public DanhSachLichChieuTheoNgay(String ngayChieu, List<String> gioChieu) {
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public List<String> getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(List<String> gioChieu) {
        this.gioChieu = gioChieu;
    }
}
