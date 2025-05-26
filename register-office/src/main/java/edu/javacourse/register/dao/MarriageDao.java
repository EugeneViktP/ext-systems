package edu.javacourse.register.dao;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class MarriageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);
    private EntityManager entityManager;

    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

//    public MarriageDao() {
//        EntityManagerFactory factory = Persistence
//                .createEntityManagerFactory("myPersistenceUnit");
//        entityManager = factory.createEntityManager();
//    }


    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate is called: {}", test);
        return null;
    }
}
