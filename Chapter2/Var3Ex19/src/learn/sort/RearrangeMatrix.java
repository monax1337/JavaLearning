package learn.sort;

public class RearrangeMatrix {
    public int[][] rearrangeMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] sortedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            sortedMatrix[i] = matrix[i].clone();
        }

        for (int i = 0; i < n; i++) {
            int maxIndexI = i;
            int maxIndexJ = i;
            int maxValue = Integer.MIN_VALUE;
            for (int k = i; k < n; k++) {
                for (int l = i; l < n; l++) {
                    if (sortedMatrix[k][l] > maxValue) {
                        maxValue = sortedMatrix[k][l];
                        maxIndexI = k;
                        maxIndexJ = l;
                    }
                }
            }
            int temp = sortedMatrix[i][i];
            sortedMatrix[i][i] = sortedMatrix[maxIndexI][maxIndexJ];
            sortedMatrix[maxIndexI][maxIndexJ] = temp;
        }

        return sortedMatrix;
    }
}
