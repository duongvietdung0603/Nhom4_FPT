package dvd.duongvietdung.DatVeXemPhim.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/admin")
    public String index(){
        return "Admin/loginAdmin";
    }

    @GetMapping("/admin/staff/")
    public String staff(){
        return "Admin/Staff/index";
    }
}
