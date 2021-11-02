package com.company;

import java.util.Random;

public class pra_02 {

    public static void main(String[] args) {

//        int[][] a = new int[5][5];
        int[][] a = new int[4][5];
        fillMat(a);
        printMat(a);
//        System.out.println(q1(a));
//        System.out.println(q2(a));
        q3(a);

    }

    //O(n)
    public static int q1(int[][] a) {
        int sum = 0;
        for (int i = 0, n = a.length; i < n; i++) {
            sum += a[i][i];
        }
        return sum;
    }

    //O(n)
    public static int q2(int[][] a) {
        int sum = 0;
        int i = 0, j = a.length - 1;
        int n = a.length;
        while (i < n) {
            sum += a[i++][j--];
        }
        return sum;
    }

    //O(n^2)
    public static void q3(int[][] a) {
        int sum = 0;
        int row = 0;
        int n = a.length;
        while (row < n) {
            for (int j = 0; j < a[row].length; j++) {
                sum += a[row][j];
            }
            System.out.println("Sum= " + sum + " row= " + row);
            sum = 0;
            row++;
        }
    }

    public static void fillMat(int[][] a) {
        Random rd = new Random();
        for (int i = 0, row = a.length; i < row; i++)
            for (int j = 0, col = a[i].length; j < col; j++)
                a[i][j] = rd.nextInt(9);
    }

    public static void printMat(int[][] a) {
        for (int i = 0, row = a.length; i < row; i++) {
            for (int j = 0, col = a[i].length; j < col; j++)
                System.out.printf(a[i][j] + "  ");
            System.out.println();
        }
    }


}
