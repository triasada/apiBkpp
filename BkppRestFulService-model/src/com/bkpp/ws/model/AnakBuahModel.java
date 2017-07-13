/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;

import com.bkpp.ws.model.vo.anakbuah.AnakBuahDetail;
import com.bkpp.ws.model.vo.anakbuah.AnakBuahList;
import com.bkpp.ws.model.vo.anakbuah.AnakBuahOut;
import com.bkpp.ws.model.vo.anakbuah.AnakBuahRequest;
import com.bkpp.ws.model.vo.anakbuah.AnakBuahResponse;
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
public class AnakBuahModel extends JdbcTemplate {

    public AnakBuahModel(DataSource dataSource) {
        super(dataSource);
    }

    public AnakBuahResponse getAnakBuah(AnakBuahRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();
        AnakBuahOut out = new AnakBuahOut();
        AnakBuahResponse response = new AnakBuahResponse();
        AnakBuahList buahList = new AnakBuahList();
        
        String parent = request.getAnakBuahIn().getParent();
        String kdOrganisasi = request.getAnakBuahIn().getKdOrganisasi();
        List<Map<String, Object>> result = getAnakBuah(parent, kdOrganisasi);
        
        List<AnakBuahDetail> list = new ArrayList();
        if (result.size() > 0) {
            for (Map<String, Object> next : result) {
                AnakBuahDetail detail = new AnakBuahDetail();
                detail.setIdIdentitas(((Integer) next.get("id_identitas")).toString());
                detail.setKdJabatan((String) next.get("kd_jabatan"));
                detail.setKdOrganisasi((String) next.get("kd_organisasi"));
                detail.setNamaLengkap((String) next.get("nama_lengkap"));
                detail.setNip((String) next.get("nip"));
                detail.setParent(((Integer) next.get("parent")).toString());
                list.add(detail);
            }
            buahList.setAnakBuahDetail(list);
            out.setAnakBuahList(buahList);

            errorMessage.setErrorApi("anakBuah");
            errorMessage.setErrorCode("00");
            errorMessage.setErrorMessage("suksess");
        } else {
            errorMessage.setErrorApi("anakBuah");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Data not Found , nip ini tidak punya anak buah");
        }
        response.setErrorMessage(errorMessage);
        response.setAnakBuahOut(out);
        return response;
    }

    private List<Map<String, Object>> getAnakBuah(String parent, String kdOrganisasi) {
        String sql = "SELECT a.nama_lengkap,a.nip,a.kd_organisasi,i.id_identitas, rj.kd_jabatan,tj.parent\n"
                + "FROM simpeg.users a\n"
                + "join simpeg.identitas i on i.nip = a.nip\n"
                + "join simpeg.riwayat_jabatan rj on rj.id_identitas = i.id_identitas\n"
                + "join simpeg.tabel_jabatan tj on tj.kd_jabatan = rj.kd_jabatan\n"
                + "where tj.parent= ? "
                + "and a.kd_organisasi = ?";
        try{
            List<Map<String, Object>> result = this.queryForList(sql,new Object[]{parent,kdOrganisasi});
            return result;
        }catch(DataAccessException dae){
            System.out.println("Error : "+dae);
            return null;
        }
    }
}
