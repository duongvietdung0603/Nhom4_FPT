package dvd.duongvietdung.DatVeXemPhim.repository;

import dvd.duongvietdung.DatVeXemPhim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
