package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private String url = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
    private String user = "root";
    private String password = "root";

    public void add(String name) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getById(int id) {
        String sql = "SELECT name FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void updateUserName(int id, String newName) {
//        String sql = "UPDATE users SET name = ? WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, newName);
//            pstmt.setInt(2, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
