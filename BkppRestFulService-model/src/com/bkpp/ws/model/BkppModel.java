/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;
import com.bkpp.ws.logic.QueryBkp;
import com.bkpp.ws.model.vo.cariNip.CariNipOut;
import com.bkpp.ws.model.vo.cariNip.CariNipRequest;
import com.bkpp.ws.model.vo.cariNip.CariNipRespons;
import com.bkpp.ws.model.vo.employ.EmployReq;
import com.bkpp.ws.model.vo.employ.EmployRes;
import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;
import java.sql.Timestamp;
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
        List<Map<String, Object>> result = queryBkp.getEmploy(employReq.getEmployIn());
        employRes.setEmployOut("EmployOut");
        
        return employRes;     
    }
    
    public CariNipRespons getCariNip(CariNipRequest request){
        CariNipRespons respons = new CariNipRespons();
        QueryBkp queryBkp = new QueryBkp(singleConn.ds);
        CariNipOut cariNipOut = new CariNipOut();
        ErrorMessage errorMessage = new ErrorMessage();
        
        String nip = request.getCariNipIn();
        
        boolean result = queryBkp.cariNip(nip);
        if (result) {
            errorMessage.setErrorApi("cariNip");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("Sukses");
        } else {
            errorMessage.setErrorApi("cariNip");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Invalid Username or Password");
        }
        cariNipOut.setErrorMessage(errorMessage);
        respons.setCariNipOut(nip);
        return respons;
        
    }
}
