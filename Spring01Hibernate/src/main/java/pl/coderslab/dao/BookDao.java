package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager em;

    public void saveBook(Book book) {
        em.persist(book);
    }

    public void updateBook(Book book) {
        em.merge(book);
    }

    public Book getBookById(long id) {
        return em.find(Book.class, id);
    }

    public List<Book> getAllBooks(){
        Query query = em.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(Long rate){
        Query query = em.createQuery("SELECT b FROM Book b where rating >:rating");
        query.setParameter("rating",rate);
        return query.getResultList();
    }

    public void deleteBook(Book book) {
        em.remove(em.contains(book) ? book : em.merge(book));
    }
}

