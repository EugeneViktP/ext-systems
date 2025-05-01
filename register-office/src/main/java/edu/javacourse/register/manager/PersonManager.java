package edu.javacourse.register.manager;

import edu.javacourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.List;

public class PersonManager {

    public static void main(String[] args) {
        sessionExample();

        jpaExample();

    }

    private static void jpaExample() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Василий");
        p.setLastName("Сидоров");
        em.persist(p);
        System.out.println(p.getPersonId());

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List list = em.createQuery("FROM Person").getResultList();
        list.forEach(System.out::println);
        em.close();

    }

    private static void sessionExample() {
        SessionFactory sf = buildSessionFactory();

        Session session = sf.openSession();
        session.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Василий");
        p.setLastName("Сидоров");
        session.persist(p);
        Long id = p.getPersonId();
        System.out.println("Person's id is: " + id);

        session.getTransaction().commit();
        session.close();

        session = sf.openSession();
        Person person = session.get(Person.class, id);
        System.out.println(person);
        session.close();

        session = sf.openSession();
        List<Person> list = session.createQuery("FROM Person", Person.class).list();
        list.forEach(k -> System.out.println(k));

        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Создаем реестр сервисов из hibernate.cfg.xml
            StandardServiceRegistry standardRegistry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();

            // Создаем метаданные из реестра сервисов
            Metadata metadata = new MetadataSources(standardRegistry)
                    .getMetadataBuilder()
                    .build();

            // Создаем SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
