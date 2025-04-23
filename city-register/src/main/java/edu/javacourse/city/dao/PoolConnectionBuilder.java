package edu.javacourse.city.dao;

import edu.javacourse.city.web.CheckPersonServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jakarta.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder{

    private DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(PoolConnectionBuilder.class);

    public PoolConnectionBuilder() {

        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");
        } catch (NamingException ex) {
            logger.error("", ex);
        }
    }



    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
