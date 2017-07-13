/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.nip;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class NipAutoCompleteResponse {
    NipAutoCompleteOut autoCompleteOut;
    ErrorMessage errorMessage;

    public NipAutoCompleteOut getAutoCompleteOut() {
        return autoCompleteOut;
    }

    public void setAutoCompleteOut(NipAutoCompleteOut autoCompleteOut) {
        this.autoCompleteOut = autoCompleteOut;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
