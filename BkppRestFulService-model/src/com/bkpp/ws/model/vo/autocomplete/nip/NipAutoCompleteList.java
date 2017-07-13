/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.nip;

import java.util.List;

/**
 *
 * @author mukticahya
 */
public class NipAutoCompleteList {
    List<NipAutoCompleteDetail> autoCompleteDetail;

    public List<NipAutoCompleteDetail> getAutoCompleteDetail() {
        return autoCompleteDetail;
    }

    public void setAutoCompleteDetail(List<NipAutoCompleteDetail> autoCompleteDetail) {
        this.autoCompleteDetail = autoCompleteDetail;
    }
    
}
