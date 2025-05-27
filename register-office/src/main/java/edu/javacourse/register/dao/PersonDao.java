package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findPersons() {
        TypedQuery<Person> query = entityManager.createNamedQuery(("Person.findPersons"), Person.class);
//        query.setParameter("personId", 2L);
        return query.getResultList();
    }


    public Long addPerson(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person.getPersonId();
    }
}
