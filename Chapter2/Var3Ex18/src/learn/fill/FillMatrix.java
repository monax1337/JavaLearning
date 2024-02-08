package learn.fill;

import java.util.Random;

public class FillMatrix {
    public int[][] fillMatrix(int n){
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }
}
