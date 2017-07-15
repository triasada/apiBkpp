/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model.vo.autocomplete.jabatan;

/**
 *
 * @author mukticahya
 */
public class JabatanAutoCompleteDetail {
    String kdJabatan;
    String namaJabatan;
    String kdOrganisasi;

    public String getKdOrganisasi() {
        return kdOrganisasi;
    }

    public void setKdOrganisasi(String kdOrganisasi) {
        this.kdOrganisasi = kdOrganisasi;
    }
    
    public String getKdJabatan() {
        return kdJabatan;
    }

    public void setKdJabatan(String kdJabatan) {
        this.kdJabatan = kdJabatan;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }
    
}
