package edu.javacourse.city.web;

import edu.javacourse.city.dao.PersonCheckDao;
import edu.javacourse.city.dao.PoolConnectionBuilder;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {


    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);
    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        logger.info("SERVLET is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("Get CheckPerson - called");


        req.setCharacterEncoding("UTF-8");
//        String surname = req.getParameter("surname");

        PersonRequest pr = new PersonRequest();
        pr.setSurName(req.getParameter("surname"));
        pr.setGivenName(req.getParameter("givenname"));
        pr.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        pr.setDateOfBirth(dateOfBirth);
        pr.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        pr.setBuilding(req.getParameter("building"));
        pr.setExtension(req.getParameter("extension"));
        pr.setApartment(req.getParameter("apartment"));


        try {
//            PersonCheckDao dao = new PersonCheckDao();
            PersonResponse ps = dao.checkPerson(pr);
            if (ps.isRegistered()) {
                resp.getWriter().write("Registered");
        } else {
            resp.getWriter().write("Not registered");
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

