package com.bkpp.ws.model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class SingleConn {
//  private static final Logger log = Logger.getLogger("");

    public static SingleConnectionDataSource ds;
    public static Connection conn;
    Session session = null;

    public SingleConn() {
        String host = "simpeg.tangerangselatankota.go.id";
        String servUser = "root";
        String servPwd = "bkpp::2016!123";
        int port = 22;

        String rhost = "localhost";
        int rport = 3306;
        int lport = 3307;

        String driverName = "com.mysql.jdbc.Driver";
        String db2Url = "jdbc:mysql://localhost:" + lport + "/simpeg";
        String dbUsr = "root";
        String dbPwd = "bkpp::2016!123";

        this.ds = new SingleConnectionDataSource();

        this.ds.setDriverClassName(driverName);
        this.ds.setUrl(db2Url);
        this.ds.setUsername(dbUsr);
        this.ds.setPassword(dbPwd);
        try {
            JSch jsch = new JSch();
            // Get SSH session
            session = jsch.getSession(servUser, host, port);
            session.setPassword(servPwd);
            java.util.Properties config = new java.util.Properties();
            // Never automatically add new host keys to the host file
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            // Connect to remote server
            session.connect();
            // Apply the port forwarding
            session.setPortForwardingL(lport, rhost, rport);
            // Connect to remote database
            conn = DriverManager.getConnection(db2Url, dbUsr, dbPwd);
//      log.log(Level.INFO, "Database connection success");
            System.out.println("Database connection success");
        } catch (SQLException e) {
//      log.log(Level.SEVERE, "Database connection error: {0}", e.getMessage());
            System.out.println("Database connection error: {0}" + e.getMessage());
        } catch (JSchException ex) {
            Logger.getLogger(SingleConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
