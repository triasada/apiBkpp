/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.api;

import com.bkpp.ws.model.AutoCompleteModel;
import com.bkpp.ws.model.SingleConn;
import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteRequest;
import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteResponse;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteRequest;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteResponse;
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
public class AutoCompleteController {

    @RequestMapping(value = "/nipAutoComplete", method = RequestMethod.POST)
    public ResponseEntity<NipAutoCompleteResponse> nipAutoComplete(@RequestBody NipAutoCompleteRequest request) throws SQLException {
        SingleConn conn = new SingleConn();
        AutoCompleteModel model = new AutoCompleteModel(conn.ds);
        NipAutoCompleteResponse response = model.getNipAutoComplete(request);
        conn.closedSession();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/skpdAutoComplete", method = RequestMethod.POST)
    public ResponseEntity<SkpdAutoCompleteResponse> skpdAutoComplete(@RequestBody SkpdAutoCompleteRequest request) throws SQLException {
        SingleConn conn = new SingleConn();
        AutoCompleteModel model = new AutoCompleteModel(conn.ds);
        SkpdAutoCompleteResponse response = model.getSkpdAutoComplete(request);
        conn.closedSession();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
