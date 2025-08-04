package dao;

import java.sql.*;
import java.util.*;
import model.EHR;
import util.DBConnection;
import model.EHR;
import util.DBConnection;

public class EHRDAO {


    public void addEHR(EHR ehr) {
        String sql = "INSERT INTO ehr(patient_id, diagnosis, treatment, doctor_name, date, notes) VALUES (?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, ehr.getPatientId());
            ps.setString(2, ehr.getDiagnosis());
            ps.setString(3, ehr.getTreatment());
            ps.setString(4, ehr.getDoctorName());
            ps.setDate(5, new java.sql.Date(ehr.getDate().getTime()));
            ps.setString(6, ehr.getNotes());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    ehr.setId(rs.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all EHR records
    public List<EHR> getAllEHR() {
        List<EHR> list = new ArrayList<>();
        String sql = "SELECT * FROM ehr";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                EHR ehr = new EHR(
                        rs.getInt("patient_id"),
                        rs.getString("diagnosis"),
                        rs.getString("treatment"),
                        rs.getString("doctor_name"),
                        rs.getDate("date"),
                        rs.getString("notes")
                );
                ehr.setId(rs.getInt("id")); // set id separately
                list.add(ehr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get all EHR records for a specific patient
    public List<EHR> getEHRByPatientId(int patientId) {
        List<EHR> list = new ArrayList<>();
        String sql = "SELECT * FROM ehr WHERE patient_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EHR ehr = new EHR(
                            rs.getInt("patient_id"),
                            rs.getString("diagnosis"),
                            rs.getString("treatment"),
                            rs.getString("doctor_name"),
                            rs.getDate("date"),
                            rs.getString("notes")
                    );
                    ehr.setId(rs.getInt("id"));
                    list.add(ehr);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Delete an EHR record by ID
    public void deleteEHR(int id) {
        String sql = "DELETE FROM ehr WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
