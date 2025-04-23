package edu.javacourse.city.web;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

@Path("/check")
public class CheckPersonService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonRequest checkPerson() {

        PersonRequest pr = new PersonRequest();
        pr.setSurName("Васильев");
        pr.setGivenName("Павел");
        pr.setPatronymic("Николаевич");
        pr.setDateOfBirth(LocalDate.of(1995, 3, 18));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");
        return pr;
    }
}


// GET /city-register-1.0/rest/check/101?name1=value1