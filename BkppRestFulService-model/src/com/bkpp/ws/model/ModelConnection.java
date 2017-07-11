package com.bkpp.ws.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

/**
 *
 * @author Harkat
 * @since June 22, 2016
 */
public class ModelConnection extends JdbcTemplate {

    public SingleConnectionDataSource ds;
    public static Connection connection;

    public ModelConnection() {
        String jdbcURL = "jdbc:oracle:thin:@172.16.241.41:1521:office";
        String username = "ifsapp";
        String password = "ifsappq";

        ds = new SingleConnectionDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl(jdbcURL);
        ds.setUsername(username);
        ds.setPassword(password);

        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ModelConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

//        InputStream is = getClass().getResourceAsStream("/com/jict/ess/model/login/log4j.properties");
//        PropertyConfigurator.configure(is);

//        InputStream is = getClass().getResourceAsStream("/com/jict/ess/model/login/log4j.properties");
//        PropertyConfigurator.configure(is);

    }

}
