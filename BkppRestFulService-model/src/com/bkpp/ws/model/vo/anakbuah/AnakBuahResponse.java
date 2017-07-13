/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.anakbuah;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class AnakBuahResponse {
    AnakBuahOut anakBuahOut;
    ErrorMessage errorMessage;

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    

    public AnakBuahOut getAnakBuahOut() {
        return anakBuahOut;
    }

    public void setAnakBuahOut(AnakBuahOut anakBuahOut) {
        this.anakBuahOut = anakBuahOut;
    }
    
}
