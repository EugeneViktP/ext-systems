package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    List<Person> findPersons();
//    Long addPerson(Person person);

}
