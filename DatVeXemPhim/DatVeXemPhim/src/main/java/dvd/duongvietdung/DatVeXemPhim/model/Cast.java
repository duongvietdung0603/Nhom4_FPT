package dvd.duongvietdung.DatVeXemPhim.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;

    @ManyToMany(mappedBy = "casts")
    private Set<Movice> movices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Movice> getMovices() {
        return movices;
    }

    public void setMovices(Set<Movice> movices) {
        this.movices = movices;
    }

    public Cast() {
    }

    public Cast(Long id, String name, String image, Set<Movice> movices) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.movices = movices;
    }

    public Cast(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
