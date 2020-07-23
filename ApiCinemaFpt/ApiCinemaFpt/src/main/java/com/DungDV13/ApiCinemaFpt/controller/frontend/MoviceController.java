package com.DungDV13.ApiCinemaFpt.controller.frontend;

import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;


@Controller
@CrossOrigin
@RequestMapping("api/movice/")
public class MoviceController {
    @Autowired
    MoviceService moviceService;

    @PostConstruct
    public void initData(){

        for(int i=1; i<10; i++){
            Movice movice = new Movice("Tên + "+ i, "Title"+i,"content"+i , "trailer"+i, "Image"+i, "2h", "nước "+i, 202+i) ;
            moviceService.save(movice);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "5", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(moviceService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        return new ResponseEntity<>(moviceService.findById(id), HttpStatus.OK);
    }

//    @PostMapping("/insert")
//    public ResponseEntity<Object> insert(@RequestParam String name,
//                                      @RequestParam String title,
//                                      @RequestParam String content,
//                                      @RequestParam String trailer,
//                                      @RequestParam String image,
//                                      @RequestParam String thoiLuong,
//                                      @RequestParam String nuocSX,
//                                      @RequestParam int namSX, @RequestBody  Movice movice) {
//        movice = new Movice(name, title, content,trailer,image, thoiLuong, nuocSX, namSX);
//        moviceService.save(movice);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

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
