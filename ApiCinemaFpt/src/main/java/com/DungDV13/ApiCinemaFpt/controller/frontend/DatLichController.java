package com.DungDV13.ApiCinemaFpt.controller.frontend;

import com.DungDV13.ApiCinemaFpt.controller.frontend.Bean.DanhSachDatLich;
import com.DungDV13.ApiCinemaFpt.model.*;
import com.DungDV13.ApiCinemaFpt.service.HoaDonChiTietService;
import com.DungDV13.ApiCinemaFpt.service.HoaDonService;
import com.DungDV13.ApiCinemaFpt.service.LichChieuService;
import com.DungDV13.ApiCinemaFpt.service.UserService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
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
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/customer")
public class DatLichController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    UserService userService;
    @Autowired
    LichChieuService lichChieuService;




    @GetMapping("/checkCustomer")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<Boolean> checkCustomer() {
        Boolean check =true;
        return new ResponseEntity<>(check,HttpStatus.OK);
    }

    @GetMapping("/datlich/{idUser}/{idLichChieu}/{viTriGhe}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<Integer> update(@PathVariable long idUser,
                                         @PathVariable long idLichChieu,
                                         @PathVariable String viTriGhe
                                         ) {

            Date ngayDat = new Date();
            User user = userService.findById(idUser);
            LichChieu lichChieu = lichChieuService.findById(idLichChieu);

            boolean kiemTra = true;
            Integer status = 1;

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


                    HoaDon hoaDon = new HoaDon(ngayDat,soLuong, tongTien, "abc", user);
                    hoaDonService.save(hoaDon);


                    String[] catChuoi1 = viTriGhe.split("-");
                    for(String viTriGheItem:catChuoi1){
                        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDon, lichChieu, viTriGheItem);
                        hoaDonChiTietService.save(hoaDonChiTiet);
                    }
                    //            tạo mã QR
                    String maCode = "Id HoaDon: "+ hoaDon.getId() +" -- NgayDat: "+ hoaDon.getNgaDat();

//                    String QR_CODE_IMAGE_PATH = "./src/main/resources/static/Image/maCode/";
                    String QR_CODE_IMAGE_PATH = "C:\\Users\\Administrator\\Documents\\GitHub\\material-cinema\\material-cinema\\public\\img\\maQR\\";
                    String image = "QR"+hoaDon.getId()+".png";
                    try {
                        generateQRCodeImage(maCode, 350, 350, QR_CODE_IMAGE_PATH + image);
                    } catch (WriterException e) {
                        System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
                    }
                    //            end tạo mã QR
                    hoaDon.setMaQR(image);
                    hoaDonService.save(hoaDon);


                }catch (Exception e){}

            }else {
                status = 2;
            }

        return new ResponseEntity<>(status,HttpStatus.OK);
    }


    @GetMapping("/danhsachdadatlich")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<List<DanhSachDatLich>> danhsachdadatlich()  {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<DanhSachDatLich> danhSachDatLiches = new ArrayList<>();
        List<HoaDon> hoaDons = hoaDonService.danhsachdatlich(username);
        hoaDons.forEach((element) -> {
            List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietService.findByHoaDonId(element.getId());

            DanhSachDatLich ItemList = new DanhSachDatLich();
            ItemList.setIdHoaDon(element.getId());
            ItemList.setSoChoNgoi((int) element.getSoLuong());
            ItemList.setTongTien(element.getTongTien());
            ItemList.setNgayDatVe(String.valueOf(element.getNgaDat()));
            List<String> danhSachChoNgoi = new ArrayList<>();
            hoaDonChiTiets.forEach((item)->{
                ItemList.setTenPhim(item.getLichChieu().getMovice().getName());
                ItemList.setNgayChieu(String.valueOf(item.getLichChieu().getNgayChieu()));
                ItemList.setGioChieu(item.getLichChieu().getGioChieu());
                ItemList.setPhongChieu(item.getLichChieu().getPhongChieu().getName());
                if (item.getLichChieu().getStatus() == 1){
                    ItemList.setLoaiSuatChieu("chiếu sớm");
                }else {
                    ItemList.setLoaiSuatChieu(" ");
                }

                danhSachChoNgoi.add(item.getViTriGhe());

            });
            ItemList.setDanhSachChoNgo(danhSachChoNgoi);
            ItemList.setMaQR(element.getMaQR());

            danhSachDatLiches.add(ItemList);
        });


        return new ResponseEntity<>(danhSachDatLiches, HttpStatus.OK);
    }


    //Mã QR
    public void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
