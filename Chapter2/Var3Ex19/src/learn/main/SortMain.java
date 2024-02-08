package learn.main;

import learn.fill.FillMatrix;
import learn.print.PrintMatrix;
import learn.sort.RearrangeMatrix;

import java.util.Scanner;

public class SortMain {
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

        RearrangeMatrix sortedMatrix = new RearrangeMatrix();
        int[][] finalMatrix = sortedMatrix.rearrangeMatrix(originMatrix);

        System.out.println("Матрица после:");
        print.printMatrix(finalMatrix);
    }
}
