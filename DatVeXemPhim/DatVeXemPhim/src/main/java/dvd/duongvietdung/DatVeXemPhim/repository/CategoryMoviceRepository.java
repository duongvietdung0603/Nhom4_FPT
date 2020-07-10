package dvd.duongvietdung.DatVeXemPhim.repository;

import dvd.duongvietdung.DatVeXemPhim.model.CategoryMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMoviceRepository extends JpaRepository<CategoryMovie,Long> {
    CategoryMovie findByName(String a);
}
