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

import java.util.List;

public class MarriageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);
    private EntityManager entityManager;

    public MarriageDao() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("myPersistenceUnit");
        entityManager = factory.createEntityManager();
    }


    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate is called");
        List<MarriageCertificate> resultList = entityManager.createQuery(
                        "SELECT mc FROM MarriageCertificate mc WHERE mc.number = :number",
                        MarriageCertificate.class)
                .setParameter("number", request.getMarriageCertificateNumber())
                .getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
