package poems.service;

import poems.database.DatabaseConnection;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyPoemsService {
    public static void insertPoem(String author, int year, Clob content) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO poems (author, year, content) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, author);
            stmt.setInt(2, year);
            stmt.setClob(3, content);
            stmt.executeUpdate();
            stmt.close();
        }
    }

    public static void updatePoem(int poemId, Clob newContent) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE poems SET content = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setClob(1, newContent);
            stmt.setInt(2, poemId);
            stmt.executeUpdate();
            stmt.close();
        }
    }

    public static void deletePoem(int poemId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM poems WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, poemId);
            stmt.executeUpdate();
            stmt.close();
        }
    }
}
