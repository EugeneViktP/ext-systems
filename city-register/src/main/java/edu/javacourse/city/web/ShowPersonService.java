package edu.javacourse.city.web;

import edu.javacourse.city.dao.PersonCheckDao;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

@Path("/show")
public class ShowPersonService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest request) {

        System.out.println(request.toString());

        return new PersonResponse();
    }


//    @GET
//    @Path("/test-db")
//    public String testDb() {
//        try (Connection conn = connectionBuilder.getConnection()) {
//            return "DB connection OK!";
//        } catch (Exception e) {
//            return "DB connection FAILED: " + e.getMessage();
//        }
//    }
}




// GET /city-register-1.0/rest/check/101?name1=value1