/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.golongan;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class GolonganAutoCompleteResponse {
    GolonganAutoCompleteOut golonganAutoCompleteOut;
    ErrorMessage errorMessage = new ErrorMessage();

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    

    public GolonganAutoCompleteOut getGolonganAutoCompleteOut() {
        return golonganAutoCompleteOut;
    }

    public void setGolonganAutoCompleteOut(GolonganAutoCompleteOut golonganAutoCompleteOut) {
        this.golonganAutoCompleteOut = golonganAutoCompleteOut;
    }
    
}
