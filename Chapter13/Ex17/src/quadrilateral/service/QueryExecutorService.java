package quadrilateral.service;

import quadrilateral.database.DatabaseConnection;
import quadrilateral.model.Quadrilateral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutorService {
    static List<Quadrilateral> executeQuery(String query) {
        List<Quadrilateral> quadrilaterals = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                double x1 = rs.getDouble("x1");
                double y1 = rs.getDouble("y1");
                double x2 = rs.getDouble("x2");
                double y2 = rs.getDouble("y2");
                double x3 = rs.getDouble("x3");
                double y3 = rs.getDouble("y3");
                double x4 = rs.getDouble("x4");
                double y4 = rs.getDouble("y4");

                Quadrilateral quad = new Quadrilateral(x1, y1, x2, y2, x3, y3, x4, y4);
                quadrilaterals.add(quad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quadrilaterals;
    }
}
