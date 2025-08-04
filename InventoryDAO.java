package dao;
import java.sql.*;
import java.util.*;
import model.InventoryItem;
import util.DBConnection;

public class InventoryDAO {
    public void addItem(InventoryItem item) {
        String sql = "INSERT INTO inventory(name, quantity, price) VALUES (?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        String sql = "SELECT * FROM inventory";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new InventoryItem(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void updateQuantity(int id, int qty) {
        String sql = "UPDATE inventory SET quantity=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
