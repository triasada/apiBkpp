/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.jabatan;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class JabatanAutoCompleteResponse {
    JabatanAutoCompleteOut jabatanAutoCompleteOut;
    ErrorMessage errorMessage;

    public JabatanAutoCompleteOut getJabatanAutoCompleteOut() {
        return jabatanAutoCompleteOut;
    }

    public void setJabatanAutoCompleteOut(JabatanAutoCompleteOut jabatanAutoCompleteOut) {
        this.jabatanAutoCompleteOut = jabatanAutoCompleteOut;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
