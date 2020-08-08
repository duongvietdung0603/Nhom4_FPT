package com.DungDV13.ApiCinemaFpt.controller.frontend;

import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


@Controller
@CrossOrigin
@RequestMapping("api/movice/")
public class MoviceController {
    @Autowired
    MoviceService moviceService;



    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "5", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(moviceService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/getRandomChoBanner")
    public ResponseEntity<Object> getRandomChoBanner() {
        List<Movice> listMovice = moviceService.findAll();

        Random rd = new Random();
        int x = rd.nextInt(listMovice.size()-1);
        System.out.println("ramdom: "+ listMovice.get(x).getId());
        return new ResponseEntity<>(moviceService.findById(listMovice.get(x).getId()) , HttpStatus.OK);
    }

    @GetMapping("/findSuatChieuSom")
    public ResponseEntity<Page<Movice>> findSuatChieuSom(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "3", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<Page<Movice>>(moviceService.findSuatChieuSom(pageable), HttpStatus.OK);
    }

    @GetMapping("/findSuatChieuBinhThuong")
    public ResponseEntity<Page<Movice>> findSuatChieuBinhThuong(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "3", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<Page<Movice>>(moviceService.findSuatChieuBinhThuong(pageable), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        return new ResponseEntity<>(moviceService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@Validated @RequestBody Movice movice) {
        moviceService.save(movice);
        return ResponseEntity.ok().body("OK! insert successfully!");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @Validated @RequestBody Movice movice) {
        movice.setId(id);
        moviceService.save(movice);
        return ResponseEntity.ok().body("OK! update successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        moviceService.deleteById(id);
        return ResponseEntity.ok().body("OK! delete successfully!");
    }
}
