package dvd.duongvietdung.DatVeXemPhim.service;

import dvd.duongvietdung.DatVeXemPhim.model.Cast;
import dvd.duongvietdung.DatVeXemPhim.model.CategoryMovie;

import dvd.duongvietdung.DatVeXemPhim.repository.CastRepository;
import dvd.duongvietdung.DatVeXemPhim.repository.CategoryMoviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public class CategoryMoviceService {
    @Autowired
    CategoryMoviceRepository categoryMoviceRepository;

    public List<CategoryMovie> findAll() {
        return categoryMoviceRepository.findAll();
    }

    public void save(CategoryMovie categoryMovie) {
        categoryMoviceRepository.save(categoryMovie);
    }

    public CategoryMovie findById(Long id) {
        return categoryMoviceRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void delete(Long idCategory) {
        categoryMoviceRepository.deleteById(idCategory);
    }

    public CategoryMovie findByName(String s) {
        return categoryMoviceRepository.findByName(s);
    }
}
