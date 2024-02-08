package learn.sort;

import java.util.Arrays;

public class CharacteristicSort {
    public int[][] sortCharacteristic(int[][] matrix) {
        int n = matrix.length;

        int[] characteristics = new int[n];
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(matrix[i][j]);
            }
            characteristics[j] = sum;
        }

        int[][] sortedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            sortedMatrix[i] = Arrays.copyOf(matrix[i], n);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (characteristics[j] < characteristics[j + 1]) {
                    for (int k = 0; k < n; k++) {
                        int temp = sortedMatrix[k][j];
                        sortedMatrix[k][j] = sortedMatrix[k][j + 1];
                        sortedMatrix[k][j + 1] = temp;
                    }
                    int temp = characteristics[j];
                    characteristics[j] = characteristics[j + 1];
                    characteristics[j + 1] = temp;
                }
            }
        }
        return sortedMatrix;
    }
}
