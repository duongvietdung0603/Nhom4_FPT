package dvd.duongvietdung.DatVeXemPhim.service;

import dvd.duongvietdung.DatVeXemPhim.model.Cast;
import dvd.duongvietdung.DatVeXemPhim.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastService {
    @Autowired
    CastRepository castRepository;


    public List<Cast> findAll() {
        return castRepository.findAll();
    }

    public void save(Cast cast) {
        castRepository.save(cast);
    }

    public Cast findById(Long id) {
        return castRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long idCast) {
        castRepository.deleteById(idCast);
    }

    public Cast findByName(String s) {
        return castRepository.findByName(s);
    }
}
