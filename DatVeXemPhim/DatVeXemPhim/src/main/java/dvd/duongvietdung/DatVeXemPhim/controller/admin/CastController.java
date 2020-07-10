package dvd.duongvietdung.DatVeXemPhim.controller.admin;

import dvd.duongvietdung.DatVeXemPhim.model.Cast;
import dvd.duongvietdung.DatVeXemPhim.service.CastService;
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
@RequestMapping("admin/staff/cast/")
public class CastController {
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/img/cast";

    @Autowired
    CastService castService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("DanhSach",castService.findAll());
        model.addAttribute("IdNhanVien","ABC");
        return "Admin/Cast/index";
    }
    @PostMapping("insert/{IdNhanVien}")
    public String xeInsert (Model model, @PathVariable String IdNhanVien,
                            @RequestParam(name = "nameCast", required = false, defaultValue = "") String nameCast,
                            @RequestParam("files") MultipartFile[] files,
                            @RequestParam (name = "idCast", required = false, defaultValue = "") String idCast){

        StringBuilder fileNames = new StringBuilder();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename()+" ");
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("đây là tên ảnh: "+fileNames.toString());

        if(idCast.equals("")){
            Cast cast = new Cast(nameCast,fileNames.toString());
            castService.save(cast);
        }else {
            Long id = Long.valueOf(idCast);
            Cast cast = castService.findById(id);
            cast.setName(nameCast);

            if(!fileNames.toString().equals(" ")){
                cast.setImage(fileNames.toString());
            }
            castService.save(cast);
        }
        model.addAttribute("idCast",idCast);
        model.addAttribute("name",nameCast);

        return "redirect:/admin/staff/cast/";
    }

    @GetMapping("formEdit/{IdNhanVien}/{idCast}")
    public String formEdit (Model model, @PathVariable ("IdNhanVien") String IdNhanVien,@PathVariable ("idCast") Long idCast){
        model.addAttribute("ItemCast",castService.findById(idCast));
        return "Admin/Cast/formEdit";
    }

    @GetMapping("delete/{IdNhanVien}/{idCast}")
    public String delete (Model model, @PathVariable ("IdNhanVien") String IdNhanVien,@PathVariable ("idCast") Long idCast){
        castService.deleteById(idCast);
        return "redirect:/admin/staff/cast/";
    }
}
