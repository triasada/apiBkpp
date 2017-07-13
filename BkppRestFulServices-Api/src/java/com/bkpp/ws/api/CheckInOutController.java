/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.api;

import com.bkpp.ws.model.CheckInOutModel;
import com.bkpp.ws.model.LoginModel;
import com.bkpp.ws.model.SingleConn;
import com.bkpp.ws.model.vo.checkinout.CheckInOutRequest;
import com.bkpp.ws.model.vo.checkinout.CheckInOutResponse;
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
 * @since July 13, 2017
 */
@RestController
public class CheckInOutController {
    @RequestMapping(value = "/checkInOut", method = RequestMethod.POST)
    public ResponseEntity<CheckInOutResponse> checkInOut(@RequestBody CheckInOutRequest request) throws SQLException{
       SingleConn conn = new SingleConn();
        CheckInOutModel model = new CheckInOutModel(conn.ds);
        CheckInOutResponse response = model.getDataCheckInOut(request);
       conn.closedSession();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
