package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.validator.Proposition;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Title", length = 100, nullable = false)
    @Size(min=5)
    @NotNull(groups = {Proposition.class})
    private String title;
    @Column(name = "Rating", scale=2, precision=4)
    @Range(min=1,max=10)
    private Double rating;
    @Column(name = "Description", columnDefinition="TEXT")
    @Size(max=600)
    @NotNull(groups = {Proposition.class})
    private String description;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull
    private Publisher publisher;
    @Min(value = 2)
    private Integer pages;

    private boolean proposition;

    @ManyToMany
    @NotEmpty
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    //    @Override
//    public String toString() {
//        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", rating=" + rating + ", publisher="
//                + publisher + ", description=" + description + "]";
//    }  //Nadpisana metoda toString() wygenerowana przez STS


//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", author='" + authors + '\'' +
//                ", rating=" + rating +
//                ", description='" + description + '\'' +
//                ", publisher=" + publisher.getName() +
//                '}';
//    }


}
