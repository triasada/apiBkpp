/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkpp.ws.model;

import com.bkpp.ws.model.vo.checkinout.CheckInOut;
import com.bkpp.ws.model.vo.checkinout.CheckInOutIn;
import com.bkpp.ws.model.vo.checkinout.CheckInOutList;
import com.bkpp.ws.model.vo.checkinout.CheckInOutOut;
import com.bkpp.ws.model.vo.checkinout.CheckInOutRequest;
import com.bkpp.ws.model.vo.checkinout.CheckInOutResponse;
import com.bkpp.ws.model.vo.errorMessage.ErrorMessage;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mukticahya
 */
public class CheckInOutModel extends JdbcTemplate {

    public CheckInOutModel(DataSource dataSource) {
        super(dataSource);
    }

    public CheckInOutResponse getDataCheckInOut(CheckInOutRequest request) {
        CheckInOutResponse response = new CheckInOutResponse();
        CheckInOutOut checkInOutOut = new CheckInOutOut();
        ErrorMessage errorMessage = new ErrorMessage();
        CheckInOutList checkInOutList = new CheckInOutList();

        String nip = request.getCheckInOutIn().getNip();
        String checkTime = request.getCheckInOutIn().getCheckTime();

        if (checkFormatTime(checkTime, "dd-MM-yyyy") || checkTime.isEmpty()) {
            String sqlTambahan = checkTime.isEmpty()
                    ? "and date_format(scio.checktime,'%d-%m-%Y') =  date_format(sysdate(),'%d-%m-%Y')"
                    : "and date_format(scio.checktime,'%d-%m-%Y') = '" + checkTime + "' ";
            List<Map<String, Object>> result = getDataCheckInOut(nip, sqlTambahan);
            System.out.println("result : " + result);
            List<CheckInOut> list = new ArrayList();
            if (result.size() > 0) {
                for (Map<String, Object> next : result) {
                    CheckInOut checkInOut = new CheckInOut();
                    checkInOut.setNip((String) next.get("nip"));
                    checkInOut.setNama((String) next.get("nama_lengkap"));
                    checkInOut.setCheckTime(((Timestamp) next.get("checktime")).toString());
                    list.add(checkInOut);
                }
                checkInOutList.setCheckInOut(list);
                checkInOutOut.setCheckInOutList(checkInOutList);
                
                errorMessage.setErrorApi("CheckInOut");
                errorMessage.setErrorCode("00");
                errorMessage.setErrorMessage("suksess");
            } else {
                errorMessage.setErrorApi("CheckInOut");
                errorMessage.setErrorCode("E0");
                errorMessage.setErrorMessage("No Data Found");
            }
        } else {
            errorMessage.setErrorApi("CheckInOut");
            errorMessage.setErrorCode("E0");
            errorMessage.setErrorMessage("Invalid checktime Format must be (dd-mm-yyyy)");
        }
        response.setCheckInOutOut(checkInOutOut);
        response.setErrorMessage(errorMessage);
        return response;
    }

    private boolean checkFormatTime(String input, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date;
        try {
            System.out.println("masuk try");
            date = dateFormat.parse(input);
            System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

            String output = dateFormat.format(date);
            System.out.println(output); // 2013-12-04
            return true;
        } catch (ParseException e) {
//            e.printStackTrace();
            System.out.println("masuk cacth");

            return false;
        }
    }

    private List<Map<String, Object>> getDataCheckInOut(String nip, String sqlTambahan) {
        String sql = "SELECT su.nip,su.nama_lengkap,scio.checktime FROM simpeg.users su "
                + "join simpeg.userinfo sui on sui.ssn = su.nip "
                + "join simpeg.checkinout scio on scio.userid = sui.userid "
                + "where su.nip like '%" + nip + "%' " + sqlTambahan;
//                + "date_format(scio.checktime,'%d-%m-%Y') =  date_format(sysdate(),'%d-%m-%Y') and"
        System.out.println("sql : " + sql);
        try {
            List<Map<String, Object>> result = this.queryForList(sql);
            return result;
        } catch (DataAccessException dae) {
            System.out.println("Error : " + dae);
            return null;
        }
    }
}
