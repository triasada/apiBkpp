/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.checkinout;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class CheckInOutResponse {
    CheckInOutOut checkInOutOut;
    ErrorMessage errorMessage;

    public CheckInOutOut getCheckInOutOut() {
        return checkInOutOut;
    }

    public void setCheckInOutOut(CheckInOutOut checkInOutOut) {
        this.checkInOutOut = checkInOutOut;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
