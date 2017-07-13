/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;
import com.bkpp.ws.model.vo.login.LoginOut;
import com.bkpp.ws.model.vo.login.LoginRequest;
import com.bkpp.ws.model.vo.login.LoginResponse;
import java.sql.Timestamp;
import java.util.Map;
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

        String nip = request.getLoginIn().getNip();
        String password = request.getLoginIn().getPassword();

//        boolean result = login(username, password);
        boolean result = login(nip,password);
        if (result) {
            Map map = getDetailLogin(nip, password);
            errorMessage.setErrorApi("Login");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("Sukses");
            
            loginOut.setFoto((String) map.get("foto"));
            loginOut.setIdIdentitas(((Integer) map.get("id_identitas")).toString());
            loginOut.setKdJabatan((String) map.get("kd_jabatan"));
            loginOut.setMytmt(((Timestamp) map.get("mytmt")).toString());
            loginOut.setNamaLengkap((String) map.get("nama_lengkap"));
            loginOut.setNip((String) map.get("nip"));
            
        } else {
            errorMessage.setErrorApi("Login");
            errorMessage.setErrorCode("10");
            errorMessage.setErrorMessage("Invalid Username or Password");
        }
        loginOut.setErrorMessage(errorMessage);
        response.setLoginOut(loginOut);
        return response;
    }

    public boolean login(String nip,String password) {
        System.out.println("nip : " + nip);
        System.out.println("password : " + password);
//        System.out.println("password : "+ password);       
        String sql = "SELECT COUNT(1) FROM simpeg.users where nip = ? and password = ?";
        Integer result = this.queryForObject(sql, new Object[]{nip,password}, Integer.class);
        return result > 0;
    }

    public Map getDetailLogin(String nip , String password) {
        String sql = "SELECT a.nama_lengkap,a.nip,i.foto,i.id_identitas, rj.kd_jabatan ,max(mytmt) mytmt "
                + "FROM simpeg.users a  "
                + "join simpeg.identitas i on i.nip = a.nip  "
                + "join simpeg.riwayat_jabatan rj on rj.id_identitas = i.id_identitas "
                + "where a.nip=? and a.password = ?";
        Map map = this.queryForMap(sql, new Object[]{nip,password});
        return map;
    }
//     public boolean login(String username,String password){
//        System.out.println("username : "+ username);
//        System.out.println("password : "+ password);       
//        String sql = "SELECT COUNT(1) FROM simpeg.users where username = ? AND password = ?";
//        Integer result = this.queryForObject(sql, new Object[]{username,password},Integer.class);
//        return result>0;       
//    }
}
