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

    public SingleConn() throws SQLException {
        String host = "simpeg.tangerangselatankota.go.id";
        String servUser = "root";
        String servPwd = "bkpp::2016!123";
        int port = 22;

        String rhost = "localhost";
        int rport = 3306;
        int lport = 3307;

        String driverName = "com.mysql.jdbc.Driver";
        String db2Url = "jdbc:mysql://localhost:" + lport + "/simpeg?zeroDateTimeBehavior=convertToNull";
        String dbUsr = "root";
        String dbPwd = "bkpp::2016!123";

        ds = new SingleConnectionDataSource();

        ds.setDriverClassName(driverName);
        ds.setUrl(db2Url);
        ds.setUsername(dbUsr);
        ds.setPassword(dbPwd);
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
            session.setPortForwardingL("0.0.0.0", lport, rhost, rport);
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
//        finally {
//            if (conn != null && !conn.isClosed()) {
//                conn.close();
//            }
//            if (session != null && session.isConnected()) {
//                session.disconnect();
//            }
//        }
    }

    public void closedSession() {
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }

}
