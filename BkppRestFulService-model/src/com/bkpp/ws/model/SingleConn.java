package com.bkpp.ws.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class SingleConn
{
  private static final Logger log = Logger.getLogger("");
  public SingleConnectionDataSource ds;
  public static Connection conn;
  
  public SingleConn()
  {
    String jdbcURL = "jdbc:mysql://localhost:3306/InventoryMcpDev";
    String $userName = "root";
    String $password = "bkpp::2016!123";
    
    this.ds = new SingleConnectionDataSource();
    
    this.ds.setDriverClassName("com.mysql.jdbc.Driver");
    this.ds.setUrl(jdbcURL);
    this.ds.setUsername($userName);
    this.ds.setPassword($password);
    try
    {
      conn = DriverManager.getConnection(jdbcURL, $userName, $password);
      log.log(Level.INFO, "Database connection success");
    }
    catch (SQLException e)
    {
      log.log(Level.SEVERE, "Database connection error: {0}", e.getMessage());
    }
  }
}
