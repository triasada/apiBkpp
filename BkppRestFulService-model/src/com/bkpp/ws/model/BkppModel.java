/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;
import com.bkpp.ws.logic.QueryBkp;
import com.bkpp.ws.model.vo.employ.EmployReq;
import com.bkpp.ws.model.vo.employ.EmployRes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author novryanizm
 */
public class BkppModel extends JdbcTemplate{
    
    public  BkppModel(DataSource dataSource){
        super(dataSource);
    }
    
    SingleConn singleConn = new SingleConn();
    
    public EmployRes getEmployee(EmployReq employReq){
        EmployRes employRes = new EmployRes();
        QueryBkp queryBkp = new QueryBkp(singleConn.ds);
        List<Map<String, Object>> result = queryBkp.getEmploy(employReq.getNip());
        employRes.setNama("nama");
        
        return employRes;
        
    }
}
