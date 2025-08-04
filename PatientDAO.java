package dao;
import java.sql.*;
import java.util.*;
import model.Patient;
import util.DBConnection;

public class PatientDAO {
    public void addPatient(Patient p) {
        String sql = "INSERT INTO patient(name, age, gender, phone, address) VALUES (?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getAddress());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM patient");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Patient(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("gender"),
                        rs.getString("phone"), rs.getString("address")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
