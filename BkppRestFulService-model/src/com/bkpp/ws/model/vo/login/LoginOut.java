/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.login;

import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;

/**
 *
 * @author mukticahya
 */
public class LoginOut {
    ErrorMessage errorMessage;
    String namaLengkap;
    String nip;
    String foto;
    String idIdentitas;
    String kdJabatan;
    String mytmt;

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdIdentitas() {
        return idIdentitas;
    }

    public void setIdIdentitas(String idIdentitas) {
        this.idIdentitas = idIdentitas;
    }

    public String getKdJabatan() {
        return kdJabatan;
    }

    public void setKdJabatan(String kdJabatan) {
        this.kdJabatan = kdJabatan;
    }

    public String getMytmt() {
        return mytmt;
    }

    public void setMytmt(String mytmt) {
        this.mytmt = mytmt;
    }
    
    

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
