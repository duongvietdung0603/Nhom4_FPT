package com.DungDV13.ApiCinemaFpt.controller.frontend;

import com.DungDV13.ApiCinemaFpt.model.HoaDon;
import com.DungDV13.ApiCinemaFpt.model.HoaDonChiTiet;
import com.DungDV13.ApiCinemaFpt.model.LichChieu;
import com.DungDV13.ApiCinemaFpt.model.User;
import com.DungDV13.ApiCinemaFpt.service.HoaDonChiTietService;
import com.DungDV13.ApiCinemaFpt.service.HoaDonService;
import com.DungDV13.ApiCinemaFpt.service.LichChieuService;
import com.DungDV13.ApiCinemaFpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Date;



@Controller
@CrossOrigin
@RequestMapping("api/customer/")
public class DatLichController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    UserService userService;
    @Autowired
    LichChieuService lichChieuService;


    @GetMapping("/datlich/{idUser}/{idLichChieu}/{viTriGhe}")
    public ResponseEntity<Boolean> update(@PathVariable long idUser,
                                         @PathVariable long idLichChieu,
                                         @PathVariable String viTriGhe
                                         ) {

            Date ngayDat = new Date();
            User user = userService.findById(idUser);
            LichChieu lichChieu = lichChieuService.findById(idLichChieu);

            boolean kiemTra = true;
            boolean status = true;

            try {
                String[] catChuoi = viTriGhe.split("-");
                for(String viTriGheItem:catChuoi){
                    HoaDonChiTiet hoaDonChiTiet= hoaDonChiTietService.kiemTraViTriGhe(lichChieu.getId(), viTriGheItem);
                    if(hoaDonChiTiet != null){
                        kiemTra = false;
                        break;
                    }
                }
            }catch (Exception e){
                kiemTra = false;
            }

            System.out.println("kiểm tra: "+ kiemTra);
            if (kiemTra == true){
                try {
                    String[] catChuoi2 = viTriGhe.split("-");
                    int soLuong = catChuoi2.length;
                    double tongTien = 0;
                    tongTien = lichChieu.getPrice() * soLuong;
                    HoaDon hoaDon = new HoaDon(ngayDat, tongTien, user);
                    hoaDonService.save(hoaDon);


                    String[] catChuoi1 = viTriGhe.split("-");
                    for(String viTriGheItem:catChuoi1){
                        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDon, lichChieu, viTriGheItem);
                        hoaDonChiTietService.save(hoaDonChiTiet);
                        tongTien = tongTien+ lichChieu.getPrice();
                    }

                }catch (Exception e){}

            }else {
                status = false;
            }

        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
