package poems.service;

import poems.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryPoemsService {
    public static void mostExclamationSentences(String author) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT content FROM poems WHERE author = ? ORDER BY (LENGTH(content) - LENGTH(REPLACE(content, '!', ''))) DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String poemContent = rs.getString("content");
                System.out.println("Стихотворение с наибольшим количеством восклицательных предложений от " + author + ":\n" + poemContent);
            } else {
                System.out.println("Стихотворения от " + author + " не найдены");
            }

            rs.close();
            stmt.close();
        }
    }

    public static void leastDeclarativeSentences(String author) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT content FROM poems WHERE author = ? ORDER BY (LENGTH(content) - LENGTH(REPLACE(content, '.', ''))) ASC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String poemContent = rs.getString("content");
                System.out.println("Стихотворение с наименьшим количеством декларативных предложений от " + author + ":\n" + poemContent);
            } else {
                System.out.println("Стихотворения от " + author + " не найдены");
            }

            rs.close();
            stmt.close();
        }
    }

    public static void countSonnets(String author) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) AS sonnet_count FROM (SELECT content FROM poems WHERE author = ?) AS poem_contents WHERE LENGTH(REPLACE(content, CHAR(10), '')) = 14";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int sonnetCount = rs.getInt("sonnet_count");
                System.out.println("Количество сонетов от " + author + ": " + sonnetCount);
            } else {
                System.out.println("Стихотворения от " + author + " не найдены");
            }

            rs.close();
            stmt.close();
        }
    }
}
