/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.cariNip;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;


/**
 *
 * @author novryanizm
 */
public class CariNipOut {
    String hasilNip;
    ErrorMessage errorMessage;

    public String getHasilNip() {
        return hasilNip;
    }

    public void setHasilNip(String hasilNip) {
        this.hasilNip = hasilNip;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }


    
}
