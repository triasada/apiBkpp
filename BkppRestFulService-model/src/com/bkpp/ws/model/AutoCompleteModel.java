/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;

import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteDetail;
import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteList;
import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteOut;
import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteRequest;
import com.bkpp.ws.model.vo.autocomplete.nip.NipAutoCompleteResponse;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteDetail;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteList;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteOut;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteRequest;
import com.bkpp.ws.model.vo.autocomplete.skpd.SkpdAutoCompleteResponse;
import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mukticahya
 */
public class AutoCompleteModel extends JdbcTemplate {

    public AutoCompleteModel(DataSource dataSource) {
        super(dataSource);
    }

    public NipAutoCompleteResponse getNipAutoComplete(NipAutoCompleteRequest request) {
        NipAutoCompleteResponse response = new NipAutoCompleteResponse();
        NipAutoCompleteOut out = new NipAutoCompleteOut();
        NipAutoCompleteList outList = new NipAutoCompleteList();
        ErrorMessage errorMessage = new ErrorMessage();

        String nip = request.getNipAutoCompleteIn().getNip();
        List<Map<String, Object>> result = getDataNipAC(nip);
        List<NipAutoCompleteDetail> list = new ArrayList();
        if (result.size() > 0) {
            for (Map<String, Object> next : result) {
                NipAutoCompleteDetail detail = new NipAutoCompleteDetail();
                detail.setNamaLengkap((String) next.get("nama_lengkap"));
                detail.setNip((String) next.get("nip"));
                list.add(detail);
            }
            outList.setAutoCompleteDetail(list);
            out.setNipAutoCompleteList(outList);

            errorMessage.setErrorApi("nipAutoComplete");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("suksess");
        } else {
            errorMessage.setErrorApi("nipAutoComplete");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Data not Found");
        }
        response.setErrorMessage(errorMessage);
        response.setAutoCompleteOut(out);
        return response;
    }

    public SkpdAutoCompleteResponse getSkpdAutoComplete(SkpdAutoCompleteRequest request) {
        SkpdAutoCompleteResponse response = new SkpdAutoCompleteResponse();
        SkpdAutoCompleteOut out = new SkpdAutoCompleteOut();
        SkpdAutoCompleteList outList = new SkpdAutoCompleteList();
        ErrorMessage errorMessage = new ErrorMessage();

        String namaOrganisasi = request.getSkpdAutoCompleteIn().getNamaOrganisasi();
        List<Map<String, Object>> result = getDataSkpdAc(namaOrganisasi);
        List<SkpdAutoCompleteDetail> list = new ArrayList();
        if (result.size() > 0) {
            for (Map<String, Object> next : result) {
                SkpdAutoCompleteDetail detail = new SkpdAutoCompleteDetail();
                detail.setKdOrganisasi((String) next.get("kd_organisasi"));
                detail.setNamaOrganisasi((String) next.get("nama_organisasi"));
                list.add(detail);
            }
            outList.setSkpdAutoCompleteDetail(list);
            out.setSkpdAutoCompleteList(outList);

            errorMessage.setErrorApi("skpdAutoComplete");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("suksess");
        } else {
            errorMessage.setErrorApi("skpdAutoComplete");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Data not Found");
        }
        response.setErrorMessage(errorMessage);
        response.setSkpdAutoCompleteOut(out);
        return response;
    }
    public SkpdAutoCompleteResponse getJabatanAutoComplete(SkpdAutoCompleteRequest request) {
        SkpdAutoCompleteResponse response = new SkpdAutoCompleteResponse();
        SkpdAutoCompleteOut out = new SkpdAutoCompleteOut();
        SkpdAutoCompleteList outList = new SkpdAutoCompleteList();
        ErrorMessage errorMessage = new ErrorMessage();

        String namaOrganisasi = request.getSkpdAutoCompleteIn().getNamaOrganisasi();
        List<Map<String, Object>> result = getDataSkpdAc(namaOrganisasi);
        List<SkpdAutoCompleteDetail> list = new ArrayList();
        if (result.size() > 0) {
            for (Map<String, Object> next : result) {
                SkpdAutoCompleteDetail detail = new SkpdAutoCompleteDetail();
                detail.setKdOrganisasi((String) next.get("kd_organisasi"));
                detail.setNamaOrganisasi((String) next.get("nama_organisasi"));
                list.add(detail);
            }
            outList.setSkpdAutoCompleteDetail(list);
            out.setSkpdAutoCompleteList(outList);

            errorMessage.setErrorApi("skpdAutoComplete");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("suksess");
        } else {
            errorMessage.setErrorApi("skpdAutoComplete");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Data not Found");
        }
        response.setErrorMessage(errorMessage);
        response.setSkpdAutoCompleteOut(out);
        return response;
    }

    private List<Map<String, Object>> getDataNipAC(String nip) {
        String sql = " select nip,nama_lengkap from simpeg.users where nip like '" + nip + "%' ";
        try {
            List<Map<String, Object>> result = this.queryForList(sql);
            return result;
        } catch (DataAccessException dae) {
            System.out.println("Error : " + dae);
            return null;
        }
    }

    private List<Map<String, Object>> getDataSkpdAc(String namaOrganisasi) {
        String sql = " SELECT kd_organisasi,nama_organisasi FROM simpeg.tbl_organisasi where nama_organisasi like '%" + namaOrganisasi + "%'";
        try {
            List<Map<String, Object>> result = this.queryForList(sql);
            return result;
        } catch (DataAccessException dae) {
            System.out.println("Error : " + dae);
            return null;
        }
    }
    private List<Map<String, Object>> getDataJabatanAc(String namaJabatan) {
        String sql = " SELECT kd_jabatan,nama_jabatan FROM simpeg.tabel_jabatan where nama_jabatan like '%"+namaJabatan+"%';";
        try {
            List<Map<String, Object>> result = this.queryForList(sql);
            return result;
        } catch (DataAccessException dae) {
            System.out.println("Error : " + dae);
            return null;
        }
    }
}
