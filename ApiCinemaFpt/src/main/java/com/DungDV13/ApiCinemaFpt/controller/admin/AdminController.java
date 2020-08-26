package com.DungDV13.ApiCinemaFpt.controller.admin;

import com.DungDV13.ApiCinemaFpt.controller.admin.Bean.DanhSachDatVeTheoLC;
import com.DungDV13.ApiCinemaFpt.controller.admin.Bean.TyLeVeTheoLC;
import com.DungDV13.ApiCinemaFpt.model.*;
import com.DungDV13.ApiCinemaFpt.repository.HoaDonChiTietRepository;
import com.DungDV13.ApiCinemaFpt.repository.HoaDonRepository;
import com.DungDV13.ApiCinemaFpt.repository.PhongChieuRepository;
import com.DungDV13.ApiCinemaFpt.repository.RoleRepository;
import com.DungDV13.ApiCinemaFpt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/admin1")
public class AdminController {

    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    private UserService userService;
    @Autowired
    private LichChieuService lichChieuService;
    @Autowired
    private MoviceService moviceService;
    @Autowired
    private PhongChieuRepository rapChieuRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository ;


    @GetMapping("/tyLeVeTheoNgay/{ngay}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<TyLeVeTheoLC>> tyLeVeTheoNgay(@PathVariable String ngay) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);

        List<TyLeVeTheoLC> ListTyLeVeTheoLCS = new ArrayList<>(); // bắtđầu là chữ thường => listTyLe...

        List<LichChieu> lichChieus = lichChieuService.findByNgayChieu(date);

        /*for (int i = 0; i < lichChieus.size(); i++) {
            TyLeVeTheoLC tyLeVeTheoLC = new TyLeVeTheoLC();
            Long soLuong = hoaDonService.countByHoaDonChiTietsLichChieuId(lichChieus.get(i).getId());
            tyLeVeTheoLC.setIdLC(String.valueOf(lichChieus.get(i).getId()));
            tyLeVeTheoLC.setName(lichChieus.get(i).getMovice().getName());
            tyLeVeTheoLC.setGioChieu(lichChieus.get(i).getGioChieu());
            tyLeVeTheoLC.setRap(lichChieus.get(i).getPhongChieu().getName());
            tyLeVeTheoLC.setTyLe(String.valueOf(soLuong));

            ListTyLeVeTheoLCS.add(tyLeVeTheoLC);
        }*/

        ListTyLeVeTheoLCS = lichChieus.stream()
                .map(this::toTyLeVeTheoLC) // chỗ này có thể viết 1 lớp mapper rồi truyền method vào
                .collect(Collectors.toList());

        return new ResponseEntity<>(ListTyLeVeTheoLCS,HttpStatus.OK);
    }


    @GetMapping("/listUserTheoLichChieu/{id}")
    public ResponseEntity<List<DanhSachDatVeTheoLC>> findByLichChieuId(@PathVariable Long id) {
        List<HoaDonChiTiet> hoaDonChiTiets =  hoaDonChiTietService.findByLichChieuId(id);
        List<String> list = new ArrayList<>();

        /*for (int i = 0; i < hoaDonChiTiets.size(); i++) {
            list.add(String.valueOf(hoaDonChiTiets.get(i).getHoaDon().getId()));
        }*/
        list = hoaDonChiTiets.stream()
                .map(HoaDonChiTiet::getHoaDon)
                .map(HoaDon::getId)
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<String> newUser =list
                .stream()
                .distinct()
                .collect(Collectors.toList());

        List<DanhSachDatVeTheoLC> danhSachDatVeTheoLCList = new ArrayList<>();
        for (int i = 0; i < newUser.size(); i++) {
            HoaDon hoaDonChiTiet = hoaDonService.findById(Long.valueOf(newUser.get(i)));
            DanhSachDatVeTheoLC veTheoLC = new DanhSachDatVeTheoLC();
            veTheoLC.setNameUser(hoaDonChiTiet.getUser().getUsername());
            veTheoLC.setSoLuong(hoaDonChiTiet.getSoLuong());
            veTheoLC.setTongTien(hoaDonChiTiet.getTongTien());
            veTheoLC.setNgayDat(String.valueOf(hoaDonChiTiet.getNgaDat()));
            veTheoLC.setEmail(hoaDonChiTiet.getUser().getEmail());

            List<HoaDonChiTiet> hoaDonChiTiets1 = hoaDonChiTietService.findByHoaDonId(hoaDonChiTiet.getId());
            List<String> ghe = new ArrayList<>();
            for (int z = 0; z < hoaDonChiTiets1.size(); z++) {
                ghe.add(hoaDonChiTiets1.get(z).getViTriGhe());
            }
            veTheoLC.setViTriGhe(ghe);

            danhSachDatVeTheoLCList.add(veTheoLC);
        }


        return new ResponseEntity<>(danhSachDatVeTheoLCList,HttpStatus.OK);
    }

    private TyLeVeTheoLC toTyLeVeTheoLC(LichChieu lichChieu) {
        TyLeVeTheoLC tyLeVeTheoLC = new TyLeVeTheoLC();
        Long soLuong = hoaDonService.countByHoaDonChiTietsLichChieuId(lichChieu.getId());
        tyLeVeTheoLC.setIdLC(String.valueOf(lichChieu.getId()));
        tyLeVeTheoLC.setName(lichChieu.getMovice().getName());
        tyLeVeTheoLC.setGioChieu(lichChieu.getGioChieu());
        tyLeVeTheoLC.setRap(lichChieu.getPhongChieu().getName());
        tyLeVeTheoLC.setTyLe(String.valueOf(soLuong));

        return tyLeVeTheoLC;
    }

//    @GetMapping("/test/{name}")
//    public ResponseEntity<List<String>> doanhthu(@PathVariable String name){
////        int doanhThuTheoPhims = moviceService.doanhThuTheoPhim(name);
////
////            System.out.println(doanhThuTheoPhims);
////            System.out.println("==========================");
//        return new ResponseEntity<>(moviceService.doanhThuTheoPhim(name),HttpStatus.OK);
//    }

}
