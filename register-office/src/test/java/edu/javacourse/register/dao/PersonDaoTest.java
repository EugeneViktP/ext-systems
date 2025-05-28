package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import edu.javacourse.register.view.MarriageRequest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(p -> {
            System.out.println("Name: " + p.getFirstName());
            System.out.println("Class: " + p.getClass().getName());
            System.out.println("Passport size: " + p.getPassports().size());
            System.out.println("Birth certificates: " + p.getBirthCertificate());
//            if (p instanceof PersonMale) {
//                System.out.println("Birth Cert Size: " + ((PersonMale) p).getBirthCertificates().size());
//                System.out.println("Marriage Cert Size: " + ((PersonMale) p).getMarriageCertificates().size());
//            } else {
//                System.out.println("Birth Cert Size: " + ((PersonFemale) p).getBirthCertificates().size());
//                System.out.println("Marriage Cert Size: " + ((PersonFemale) p).getMarriageCertificates().size());
//            }
        });
    }

    @Test
    public void findMarriageCertificates() {
//        MarriageDao dao = new MarriageDao();
//        MarriageRequest request = new MarriageRequest();
//        request.setMarriageCertificateNumber(null);
//        MarriageCertificate cert = dao.findMarriageCertificate(request);

    }
}