package dvd.duongvietdung.DatVeXemPhim.service;

import dvd.duongvietdung.DatVeXemPhim.model.Role;
import dvd.duongvietdung.DatVeXemPhim.model.User;
import dvd.duongvietdung.DatVeXemPhim.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public void save(Role user) {
        roleRepository.save(user);
    }

    public Role findById(int id) {
        return roleRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
