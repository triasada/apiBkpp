/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.nip;

/**
 *
 * @author mukticahya
 */
public class NipAutoCompleteDetail {
    String nip;
    String namaLengkap;
    String kdJabatan;
    String idIdentitas;
    String kdOrganisasi;

    public String getKdJabatan() {
        return kdJabatan;
    }

    public void setKdJabatan(String kdJabatan) {
        this.kdJabatan = kdJabatan;
    }

    public String getIdIdentitas() {
        return idIdentitas;
    }

    public void setIdIdentitas(String idIdentitas) {
        this.idIdentitas = idIdentitas;
    }

    public String getKdOrganisasi() {
        return kdOrganisasi;
    }

    public void setKdOrganisasi(String kdOrganisasi) {
        this.kdOrganisasi = kdOrganisasi;
    }
    
    

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }
    
}
