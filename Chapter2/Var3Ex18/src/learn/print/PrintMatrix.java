package learn.print;

import java.util.Arrays;

public class PrintMatrix {
    public void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
