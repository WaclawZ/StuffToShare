package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager em;

    public void save(Person person){
        em.persist(person);
    }

    public Person getById(Long id){
        return em.find(Person.class, id);
    }

    public void update(Person person){
        em.merge(person);
    }

    public List<Person> getAllPersons(){
        Query query = em.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }

    public void delete(Person person) {
        em.remove(em.contains(person) ? person : em.merge(person));
    }
}
