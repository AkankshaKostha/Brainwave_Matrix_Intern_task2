package dao;
import java.sql.*;
import java.util.*;
import model.Appointment;
import util.DBConnection;

public class AppointmentDAO {
    public void addAppointment(Appointment a) {
        String sql = "INSERT INTO appointment(patient_id, staff_id, date_time, status) VALUES (?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getStaffId());
            ps.setTimestamp(3, a.getDateTime());
            ps.setString(4, a.getStatus());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointment";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"), rs.getInt("patient_id"), rs.getInt("staff_id"),
                        rs.getTimestamp("date_time"), rs.getString("status")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void updateStatus(int id, String status) {
        String sql = "UPDATE appointment SET status=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
