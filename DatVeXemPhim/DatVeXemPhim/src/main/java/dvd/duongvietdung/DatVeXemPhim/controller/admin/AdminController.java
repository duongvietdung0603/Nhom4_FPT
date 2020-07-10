package dvd.duongvietdung.DatVeXemPhim.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/boss/")
public class AdminController {
    @GetMapping("/")
    public String index(){
        return "Admin/index";
    }
}
