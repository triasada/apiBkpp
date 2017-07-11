/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.errorMessage;

/**
 *
 * @author mukticahya
 */
public class ErrorMessage {
    String errorMessage;
    String errorCode;
    String errorApi;

    public String getErrorApi() {
        return errorApi;
    }

    public void setErrorApi(String errorApi) {
        this.errorApi = errorApi;
    }
    

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
}
