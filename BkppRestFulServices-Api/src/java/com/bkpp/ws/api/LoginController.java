package com.bkpp.ws.api;


import com.bkpp.ws.model.LoginModel;
import com.bkpp.ws.model.SingleConn;
import com.bkpp.ws.model.vo.login.LoginRequest;
import com.bkpp.ws.model.vo.login.LoginResponse;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mukti Cahya.
 * @since July 12, 2017
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> doLogin(@RequestBody LoginRequest request) throws SQLException{
       SingleConn conn = new SingleConn();
        LoginModel model = new LoginModel(conn.ds);
        LoginResponse response = model.login(request);
        conn.closedSession();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
