package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> findBooksByTitle(String title);

    List<Book> findByRatingGreaterThanEqual(Double rating);

    List<Book> findAllByAuthorsContains(Author author);

    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByPublisherId(Long id);
    List<Book> findAllByPublisherName(String publisherName);

    List<Book> findFirstByPublisherOrderByTitle(Publisher publisher);

    @Query("select b from Book b where b.title = :title")
    List<Book> findBooksByTitle(@Param("titile") String title);
    @Query("select b from Book b where b.publisher_id = ?1")
    List<Book> findBooksByPublisher(Long publisher_id);
    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findBooksByRatingBetween(Double first, Double second);
//    @Query("select * from Book b where b.publisher_id = ?1 order by b.title desc")
    @Query(value = "SELECT * FROM books WHERE publisher_id = ?1 LIMIT 1",nativeQuery = true)
    List<Book> findFirstByPublisherOrderByTitleDesc(Long publisher_id);
}
