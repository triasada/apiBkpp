/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;

import com.bkpp.ws.model.vo.autocomplete.golongan.GolonganAutoCompleteDetail;
import com.bkpp.ws.model.vo.autocomplete.golongan.GolonganAutoCompleteList;
import com.bkpp.ws.model.vo.autocomplete.golongan.GolonganAutoCompleteOut;
import com.bkpp.ws.model.vo.autocomplete.golongan.GolonganAutoCompleteRequest;
import com.bkpp.ws.model.vo.autocomplete.golongan.GolonganAutoCompleteResponse;
import com.bkpp.ws.model.vo.autocomplete.jabatan.JabatanAutoCompleteDetail;
import com.bkpp.ws.model.vo.autocomplete.jabatan.JabatanAutoCompleteList;
import com.bkpp.ws.model.vo.autocomplete.jabatan.JabatanAutoCompleteOut;
import com.bkpp.ws.model.vo.autocomplete.jabatan.JabatanAutoCompleteRequest;
import com.bkpp.ws.model.vo.autocomplete.jabatan.JabatanAutoCompleteResponse;
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

    public JabatanAutoCompleteResponse getJabatanAutoComplete(JabatanAutoCompleteRequest request) {
        JabatanAutoCompleteResponse response = new JabatanAutoCompleteResponse();
        JabatanAutoCompleteOut out = new JabatanAutoCompleteOut();
        JabatanAutoCompleteList outList = new JabatanAutoCompleteList();
        ErrorMessage errorMessage = new ErrorMessage();

        String namaJabatan = request.getJabatanAutoCompleteIn().getNamaJabatan();
        String kdOrganisasi = request.getJabatanAutoCompleteIn().getKdOrganisasi();
        List<Map<String, Object>> result = getDataJabatanAc(namaJabatan,kdOrganisasi);
        List<JabatanAutoCompleteDetail> list = new ArrayList();
        if (result.size() > 0) {
            for (Map<String, Object> next : result) {
                JabatanAutoCompleteDetail detail = new JabatanAutoCompleteDetail();
                detail.setKdJabatan((String) next.get("kd_jabatan"));
                detail.setNamaJabatan((String) next.get("nama_jabatan"));
                detail.setKdOrganisasi((String)next.get("kd_organisasi"));
                list.add(detail);
            }
            outList.setJabatanAutoCompleteDetail(list);
            out.setJabatanAutoCompleteList(outList);

            errorMessage.setErrorApi("jabatanAutoComplete");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("suksess");
        } else {
            errorMessage.setErrorApi("jabatanAutoComplete");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Data not Found");
        }
        response.setErrorMessage(errorMessage);
        response.setJabatanAutoCompleteOut(out);
        return response;
    }

    public GolonganAutoCompleteResponse getGolonganAutoComplete(GolonganAutoCompleteRequest request) {
        GolonganAutoCompleteResponse response = new GolonganAutoCompleteResponse();
        GolonganAutoCompleteOut out = new GolonganAutoCompleteOut();
        GolonganAutoCompleteList outList = new GolonganAutoCompleteList();
        ErrorMessage errorMessage = new ErrorMessage();

        String kdGolongan = request.getGolonganAutoCompleteIn().getKdGolongan();
        List<Map<String, Object>> result = getDataGolonganAc(kdGolongan);
        List<GolonganAutoCompleteDetail> list = new ArrayList();
        if (result.size() > 0) {
            for (Map<String, Object> next : result) {
                GolonganAutoCompleteDetail detail = new GolonganAutoCompleteDetail();
                detail.setKdGolongan((String) next.get("kd_golongan"));
                detail.setKepangkatan((String) next.get("kepangkatan"));
                detail.setIdGolongan(((Integer) next.get("id_golongan")).toString());
                list.add(detail);
            }
            outList.setGolonganAutoCompleteDetail(list);
            out.setGolonganAutoCompleteList(outList);

            errorMessage.setErrorApi("golonganAutoComplete");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("suksess");
        } else {
            errorMessage.setErrorApi("golonganAutoComplete");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Data not Found");
        }
        response.setErrorMessage(errorMessage);
        response.setGolonganAutoCompleteOut(out);
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

    private List<Map<String, Object>> getDataJabatanAc(String namaJabatan, String kdOrganisasi) {
        String sql = " SELECT kd_jabatan,nama_jabatan,kd_organisasi FROM simpeg.tabel_jabatan where "
                + "nama_jabatan like '%" + namaJabatan + "%' and kd_organisasi like '%" + kdOrganisasi + "%'";
        try {
            List<Map<String, Object>> result = this.queryForList(sql);
            return result;
        } catch (DataAccessException dae) {
            System.out.println("Error : " + dae);
            return null;
        }
    }

    private List<Map<String, Object>> getDataGolonganAc(String kdGolongan) {
        String sql = "SELECT kd_golongan,kepangkatan,id_golongan FROM simpeg.tabel_golongan where kd_golongan like '%" + kdGolongan + "%' ";
        try {
            List<Map<String, Object>> result = this.queryForList(sql);
            return result;
        } catch (DataAccessException dae) {
            System.out.println("Error : " + dae);
            return null;
        }
    }
}
