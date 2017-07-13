/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.api;

import com.bkpp.ws.model.AnakBuahModel;
import com.bkpp.ws.model.LoginModel;
import com.bkpp.ws.model.SingleConn;
import com.bkpp.ws.model.vo.anakbuah.AnakBuahRequest;
import com.bkpp.ws.model.vo.anakbuah.AnakBuahResponse;
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
 * @author mukticahya
 */
@RestController
public class AnakBuahController {

    @RequestMapping(value = "/anakBuah", method = RequestMethod.POST)
    public ResponseEntity<AnakBuahResponse> anakBuah(@RequestBody AnakBuahRequest request) throws SQLException {
        SingleConn conn = new SingleConn();
        AnakBuahModel model = new AnakBuahModel(conn.ds);
        AnakBuahResponse response = model.getAnakBuah(request);
        conn.closedSession();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
