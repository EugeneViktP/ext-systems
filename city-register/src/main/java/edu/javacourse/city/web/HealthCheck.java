package edu.javacourse.city.web;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;


@Path("/health")
public class HealthCheck {



    @GET
    @Path("/{id}")
    public String healthCheck(@PathParam("id") int simpleId,
                              @QueryParam("name") String simpleName) {
        return "OK";
    }
}

