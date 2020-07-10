package dvd.duongvietdung.DatVeXemPhim.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Movice")
public class Movice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String trailer;
    private String image;
    private String director;
    private int publishing;
    private String duration;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movice_category",
            joinColumns = @JoinColumn(name = "movice_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryMovie> categoryMovies;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movice_casts",
            joinColumns = @JoinColumn(name = "movice_id"),
            inverseJoinColumns = @JoinColumn(name = "casts_id")
    )
    private Set<Cast> casts;



    public Movice(Long id, String title, String content, String trailer,
                  String image, String director, int publishing,
                  String duration, Set<CategoryMovie> categoryMovies) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.trailer = trailer;
        this.image = image;
        this.director = director;
        this.publishing = publishing;
        this.duration = duration;
        this.categoryMovies = categoryMovies;
    }

    public Movice(String title, String content, String trailer, String image, String director, int publishing, String duration) {
        this.title = title;
        this.content = content;
        this.trailer = trailer;
        this.image = image;
        this.director = director;
        this.publishing = publishing;
        this.duration = duration;
    }

    public Movice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPublishing() {
        return publishing;
    }

    public void setPublishing(int publishing) {
        this.publishing = publishing;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<CategoryMovie> getCategoryMovies() {
        return categoryMovies;
    }

    public void setCategoryMovies(Set<CategoryMovie> categoryMovies) {
        this.categoryMovies = categoryMovies;
    }

    public Set<Cast> getCasts() {
        return casts;
    }

    public void setCasts(Set<Cast> casts) {
        this.casts = casts;
    }
}
