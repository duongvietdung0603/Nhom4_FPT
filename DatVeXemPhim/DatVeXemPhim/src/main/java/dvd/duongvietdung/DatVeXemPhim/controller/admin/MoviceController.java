package dvd.duongvietdung.DatVeXemPhim.controller.admin;

import dvd.duongvietdung.DatVeXemPhim.model.Cast;
import dvd.duongvietdung.DatVeXemPhim.model.CategoryMovie;
import dvd.duongvietdung.DatVeXemPhim.model.Movice;
import dvd.duongvietdung.DatVeXemPhim.service.CastService;
import dvd.duongvietdung.DatVeXemPhim.service.CategoryMoviceService;
import dvd.duongvietdung.DatVeXemPhim.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

@Controller
@RequestMapping("admin/staff/movice/")
public class MoviceController {
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/img/movice";

    @Autowired
    CastService castService;
    @Autowired
    CategoryMoviceService categoryMoviceService;
    @Autowired
    MoviceService moviceService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("DanhSach",moviceService.findAll());
        model.addAttribute("IdNhanVien","ABC");
        model.addAttribute("DanhSachCategory",categoryMoviceService.findAll());
        return "Admin/Movice/index";
    }

    @PostMapping("insert/{IdNhanVien}")
    public String Insert (Model model, @PathVariable String IdNhanVien,
                          @RequestParam(name = "title", required = false, defaultValue = "") String title,
                          @RequestParam(name = "content", required = false, defaultValue = "") String content,
                          @RequestParam(name = "trailer", required = false, defaultValue = "") String trailer,
                          @RequestParam(name = "director", required = false, defaultValue = "") String director,
                          @RequestParam(name = "publishing", required = false, defaultValue = "") String publishing,
                          @RequestParam(name = "duration", required = false, defaultValue = "") String duration,
                          @RequestParam(name = "categoryMovice", required = false, defaultValue = "") String categoryMovice,
                          @RequestParam("files") MultipartFile[] files,
                          @RequestParam (name = "idCast", required = false, defaultValue = "") String idMovice){
        System.out.println("đây là thể loại: "+categoryMovice);

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
        int a = Integer.parseInt(publishing);
        if(idMovice.equals("")){
            Movice movice = new Movice(title,content,trailer,fileNames.toString(),director,Integer.parseInt(publishing),duration);
            HashSet<CategoryMovie> categoryMovies = new HashSet<>();
            String chuoiCategory = categoryMovice;
            String abc[] = chuoiCategory.split(" ,");
            for (int i = 0; i < abc.length; i++) {
                CategoryMovie categoryMovie =  categoryMoviceService.findByName(abc[i]);
                categoryMovies.add(categoryMoviceService.findByName(abc[i]));
            }
            movice.setCategoryMovies(categoryMovies);
            moviceService.save(movice);
        }else {
            Long id = Long.valueOf(idMovice);
            Movice movice = moviceService.findById(id);
            movice.setTitle(title);
            movice.setContent(content);
            movice.setTrailer(trailer);
            movice.setDirector(director);
            movice.setPublishing(Integer.parseInt(publishing));
            movice.setDuration(duration);

            if(!fileNames.toString().equals(" ")){
                movice.setImage(fileNames.toString());
            }
            moviceService.save(movice);
        }
        return "redirect:/admin/staff/movice/";
    }
}
