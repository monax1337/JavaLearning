package learn.main;

import learn.fill.FillMatrix;
import learn.print.PrintMatrix;
import learn.sort.CharacteristicSort;

import java.util.Scanner;

public class MatrixMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int n = scanner.nextInt();
        scanner.close();

        FillMatrix filledMatrix = new FillMatrix();
        int[][] originMatrix = filledMatrix.fillMatrix(n);

        PrintMatrix print = new PrintMatrix();
        System.out.println("Матрица до:");
        print.printMatrix(originMatrix);

        CharacteristicSort sortedMatrix = new CharacteristicSort();
        int[][] finalMatrix = sortedMatrix.sortCharacteristic(originMatrix);

        System.out.println("Матрица после:");
        print.printMatrix(finalMatrix);
    }
}
