package dvd.duongvietdung.DatVeXemPhim.controller.admin;

import dvd.duongvietdung.DatVeXemPhim.model.Cast;
import dvd.duongvietdung.DatVeXemPhim.model.CategoryMovie;
import dvd.duongvietdung.DatVeXemPhim.service.CategoryMoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("admin/staff/category/")
public class CategoryMovieController {
    @Autowired
    CategoryMoviceService categoryMoviceService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("DanhSach",categoryMoviceService.findAll());
        model.addAttribute("IdNhanVien","ABC");
        return "Admin/CategoryMovice/index";
    }
    @PostMapping("insert/{IdNhanVien}")
    public String xeInsert (Model model, @PathVariable String IdNhanVien,
                            @RequestParam(name = "nameCategory", required = false, defaultValue = "") String nameCategory,
                            @RequestParam (name = "idCategory", required = false, defaultValue = "") String idCategory){

        if(idCategory.equals("")){
            CategoryMovie categoryMovie = new CategoryMovie(nameCategory);
            categoryMoviceService.save(categoryMovie);
        }else {
            Long id = Long.valueOf(idCategory);
            CategoryMovie categoryMovie  = categoryMoviceService.findById(id);
            categoryMovie.setName(nameCategory);
            categoryMoviceService.save(categoryMovie);
        }
        model.addAttribute("idCast",idCategory);
        model.addAttribute("name",nameCategory);

        return "redirect:/admin/staff/category/";
    }

    @GetMapping("formEdit/{IdNhanVien}/{idCast}")
    public String formEdit (Model model, @PathVariable ("IdNhanVien") String IdNhanVien,@PathVariable ("idCast") Long idCategory){
        model.addAttribute("ItemCategory",categoryMoviceService.findById(idCategory));
        return "Admin/CategoryMovice/formEdit";
    }

    @GetMapping("delete/{IdNhanVien}/{idCast}")
    public String delete ( @PathVariable ("IdNhanVien") String IdNhanVien,@PathVariable ("idCast") Long idCategory){
        categoryMoviceService.delete(idCategory);
        return "redirect:/admin/staff/category/";
    }
}
