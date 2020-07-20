package dvd.duongvietdung.DatVeXemPhim.controller.admin;

import dvd.duongvietdung.DatVeXemPhim.service.RoleService;
import dvd.duongvietdung.DatVeXemPhim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/staff/user/")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("DanhSach",userService.findAll());
        model.addAttribute("ChucVu",roleService.findAll());
        model.addAttribute("IdNhanVien","ABC");
        return "Admin/User/index";
    }
}
