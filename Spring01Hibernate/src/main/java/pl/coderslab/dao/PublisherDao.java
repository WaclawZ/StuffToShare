package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager em;

    public void savePublisher(Publisher publisher) {
        em.persist(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        em.merge(publisher);
    }

    public Publisher getPublisherById(long id) {
        return em.find(Publisher.class, id);
    }

    public List<Publisher> getAllPublishers(){
        Query query = em.createQuery("SELECT p FROM Publisher p");
        return query.getResultList();
    }

    public void deletePublisher(Publisher publisher) {
        em.remove(em.contains(publisher) ? publisher : em.merge(publisher));
    }
}
