/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.api;

import com.bkpp.ws.model.BkppModel;
import com.bkpp.ws.model.SingleConn;
import com.bkpp.ws.model.vo.cariNip.CariNipRequest;
import com.bkpp.ws.model.vo.cariNip.CariNipRespons;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author novryanizm
 */
@RestController
public class CariNipController {

    @RequestMapping(value = "/cariNip", method = RequestMethod.POST)
    public ResponseEntity<CariNipRespons> cariNip(@RequestBody CariNipRequest request) throws SQLException {
        SingleConn conn = new SingleConn();
        BkppModel model = new BkppModel(conn.ds);
        CariNipRespons respons = model.getCariNip(request);
        return new ResponseEntity<>(respons, HttpStatus.OK);
    }
}
