package dvd.duongvietdung.DatVeXemPhim.service;

import dvd.duongvietdung.DatVeXemPhim.model.Cast;
import dvd.duongvietdung.DatVeXemPhim.model.Movice;
import dvd.duongvietdung.DatVeXemPhim.repository.MoviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviceService {
    @Autowired
    MoviceRepository moviceRepository;

    public List<Movice> findAll() {
        return moviceRepository.findAll();
    }

    public void save(Movice cast) {
        moviceRepository.save(cast);
    }

    public Movice findById(Long id) {
        return moviceRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long idCast) {
        moviceRepository.deleteById(idCast);
    }
}
