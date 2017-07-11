/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.logic;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author novryanizm
 */
public class QueryBkp extends JdbcTemplate{
    
    public QueryBkp(DataSource dataSource){
        super(dataSource);
    }
    
    public List<Map<String, Object>> getEmploy(String nip) {
        System.out.println("TEST: "+nip);
//        String sql = "SELECT SSC.*,ROWIDTONCHAR(SSC.ROWID) ID FROM STCK_SHIPPING_CUSTOMERS SSC ";
        String sql = "SELECT "
                + "SCO.COMPANY_ID,SC.NPWP,SC.CUSTOMER_NAME,"
                + "SC.ACTIVE_STATUS,SC.CREATED,SC.CREATED_BY,SC.NOT_ACTIVE_DATE,"
                + "SC.NOT_ACTIVE_BY,SC.FREE_CHARGE_PNPK_STACK_AWAL,"
                + "SC.FREE_CHARGE_STACK_AWAL,SC.COMPANY_FK,"
                + "ROWIDTONCHAR(SC.ROWID) ID "
                + "FROM STCK_SHIPPING_CUSTOMERS SC "
                + "JOIN STCK_SHIPPING_COMPANY SCO ON SC.COMPANY_FK = SCO.COMPANY_PK "
                + "WHERE SC.COMPANY_FK =?";
        List<Map<String, Object>> result = this.queryForList(sql,new Object[]{nip});
        return result;
    }
    
    public boolean login(String username,String password){
        System.out.println("username : "+ username);
        System.out.println("password : "+ password);       
        String sql = "SELECT COUNT(1) FROM simpeg.users where username = ? AND password = ?";
        Integer result = this.queryForObject(sql, new Object[]{username,password},Integer.class);
        return result>0;       
    }
}
