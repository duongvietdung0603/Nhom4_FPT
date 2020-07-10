package dvd.duongvietdung.DatVeXemPhim.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CategoryMovice")
public class CategoryMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categoryMovies")
    private Set<Movice> movices;

    public CategoryMovie(Long id, String name, Set<Movice> movices) {
        this.id = id;
        this.name = name;
        this.movices = movices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryMovie(String name) {
        this.name = name;
    }

    public CategoryMovie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Movice> getMovices() {
        return movices;
    }

    public void setMovices(Set<Movice> movices) {
        this.movices = movices;
    }
}
