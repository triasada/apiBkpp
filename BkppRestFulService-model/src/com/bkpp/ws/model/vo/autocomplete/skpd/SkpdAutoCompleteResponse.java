/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.skpd;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class SkpdAutoCompleteResponse {
    SkpdAutoCompleteOut skpdAutoCompleteOut;
    ErrorMessage errorMessage;

    public SkpdAutoCompleteOut getSkpdAutoCompleteOut() {
        return skpdAutoCompleteOut;
    }

    public void setSkpdAutoCompleteOut(SkpdAutoCompleteOut skpdAutoCompleteOut) {
        this.skpdAutoCompleteOut = skpdAutoCompleteOut;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
