package dao;
import java.sql.*;
import java.util.*;
import model.Staff;
import util.DBConnection;

public class StaffDAO {
    public void addStaff(Staff s) {
        String sql = "INSERT INTO staff(name, role, phone) VALUES (?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getRole());
            ps.setString(3, s.getPhone());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Staff> getAllStaff() {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM staff";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Staff(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("role"), rs.getString("phone")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
