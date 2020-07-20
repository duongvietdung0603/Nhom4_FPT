package dvd.duongvietdung.DatVeXemPhim.service;

import dvd.duongvietdung.DatVeXemPhim.model.User;
import dvd.duongvietdung.DatVeXemPhim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}