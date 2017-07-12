/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;

import com.bkpp.ws.logic.QueryBkp;
import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;
import com.bkpp.ws.model.vo.login.LoginOut;
import com.bkpp.ws.model.vo.login.LoginRequest;
import com.bkpp.ws.model.vo.login.LoginResponse;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mukticahya
 * @since 12 July, 2017
 */
public class LoginModel extends JdbcTemplate {

    public LoginModel(DataSource dataSource) {
        super(dataSource);
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        LoginOut loginOut = new LoginOut();
        ErrorMessage errorMessage = new ErrorMessage();

        String username = request.getLoginIn().getUsername();
        String password = request.getLoginIn().getPassword();

//        boolean result = login(username, password);
        boolean result = login(username);
        if (result) {
            errorMessage.setErrorApi("Login");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("Sukses");
        } else {
            errorMessage.setErrorApi("Login");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Invalid Username or Password");
        }
        loginOut.setErrorMessage(errorMessage);
        response.setLoginOut(loginOut);
        return response;
    }
     public boolean login(String username){
        System.out.println("username : "+ username);
//        System.out.println("password : "+ password);       
        String sql = "SELECT COUNT(1) FROM simpeg.users where username = ? ";
        Integer result = this.queryForObject(sql, new Object[]{username},Integer.class);
        return result>0;       
    }
//     public boolean login(String username,String password){
//        System.out.println("username : "+ username);
//        System.out.println("password : "+ password);       
//        String sql = "SELECT COUNT(1) FROM simpeg.users where username = ? AND password = ?";
//        Integer result = this.queryForObject(sql, new Object[]{username,password},Integer.class);
//        return result>0;       
//    }
}
