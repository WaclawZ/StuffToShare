package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager em;

    public void saveAuthor(Author author) {
        em.persist(author);
    }

    public void updateAuthor(Author author) {
        em.merge(author);
    }

    public Author getAuthorById(long id) {
        return em.find(Author.class, id);
    }

    public List<Author> getAllAuthors(){
        Query query = em.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

    public void deleteAuthor(Author author) {
        em.remove(em.contains(author) ? author : em.merge(author));
    }
}
