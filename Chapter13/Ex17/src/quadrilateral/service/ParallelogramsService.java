package quadrilateral.service;

import quadrilateral.model.Quadrilateral;

import java.util.List;

public class ParallelogramsService {
    public static List<Quadrilateral> processParallelograms(){
        String queryParallelograms = "SELECT x1, y1, x2, y2, x3, y3, x4, y4 FROM quadrilaterals WHERE (x2 - x1) * (y3 - y1) = (x3 - x1) * (y2 - y1)";
        return QueryExecutorService.executeQuery(queryParallelograms);
    }
}
