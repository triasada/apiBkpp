/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;
import com.bkpp.ws.model.vo.cariNip.CariNipOut;
import com.bkpp.ws.model.vo.cariNip.CariNipRequest;
import com.bkpp.ws.model.vo.cariNip.CariNipRespons;
import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;
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
    
    
//    public EmployRes getEmployee(EmployReq employReq){
//        EmployRes employRes = new EmployRes();
//        QueryBkp queryBkp = new QueryBkp(singleConn.ds);
//        List<Map<String, Object>> result = queryBkp.getEmploy(employReq.getEmployIn());
//        employRes.setEmployOut("EmployOut");
//        
//        return employRes;     
//    }
    
    public CariNipRespons getCariNip(CariNipRequest request){
        CariNipRespons respons = new CariNipRespons();
//        QueryBkp queryBkp = new QueryBkp(singleConn.ds);
        CariNipOut cariNipOut = new CariNipOut();
        ErrorMessage errorMessage = new ErrorMessage();
        
        String nip = request.getCariNipIn().getNip();
        
        boolean result = cariNip(nip);
        
        if (result) {
            cariNipOut.setHasilNip(nip);
            
            errorMessage.setErrorApi("cariNip");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("Sukses");
        } else {
            errorMessage.setErrorApi("cariNip");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Invalid Username or Password");
        }
        cariNipOut.setErrorMessage(errorMessage);
        respons.setCariNipOut(cariNipOut);
        return respons;
        
    }
    public boolean cariNip(String nip){
        System.out.println("NIP yang dicari"+nip);
        
        String sql = "SELECT COUNT(1) FROM simpeg.users WHERE NIP=?";
        Integer result = this.queryForObject(sql, new Object[]{nip}, Integer.class);
        return result > 0;
    }
}
