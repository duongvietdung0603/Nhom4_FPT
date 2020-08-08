package com.DungDV13.ApiCinemaFpt.controller.frontend;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;


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
import java.util.Date;



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

    @GetMapping("/getByMovice/{id}")
    public ResponseEntity<List<LichChieu>> getByMovice(@PathVariable long id) {
        return new ResponseEntity<List<LichChieu>>(lichChieuService.findByMoviceId(id), HttpStatus.OK);
    }

    @GetMapping("/findLichChieu/{idMovice}/{ngayChieu}/{gioChieu}/{phongChieu}")
    public ResponseEntity<LichChieu> findLichChieu(@PathVariable long idMovice,
                                                         @PathVariable String ngayChieu,
                                                         @PathVariable String gioChieu,
                                                         @PathVariable long phongChieu
                                                         ) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(ngayChieu);
        return new ResponseEntity<>(lichChieuService.findLichChieu(idMovice, date, gioChieu, phongChieu), HttpStatus.OK);
    }

    @GetMapping("/viTriGheDaDuocChon/{idLich}")
    public ResponseEntity<List<String>> viTriGheDaDuocChon(@PathVariable long idLich)  {
        return new ResponseEntity<>(hoaDonChiTietService.viTriGheDaDuocChon(idLich), HttpStatus.OK);
    }

    @GetMapping("/abc")
    public ResponseEntity<List<HoaDon>> abc()  {
        return new ResponseEntity<List<HoaDon>>(hoaDonService.findAll(), HttpStatus.OK);
    }

}



