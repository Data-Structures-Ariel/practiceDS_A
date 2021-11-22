package com.company;

public class pra_04 {
    public static void main(String[] args) {
        int[] a = {20, 5, 7, 3, 2, 7, 9, 12, 357, 24, 68};
        System.out.println("Min number is "+Min(a, 0));
        System.out.println("Min number is "+Max(a, 0));
        System.out.printf("Harmonic rec = %.2f\n", HarmonicSumRec(10));
        System.out.printf("Harmonic iter = %.2f\n", HarmonicSumIter(10));
        System.out.println("Sum of digit is " +digSumRec(12345));
    }

    static public int recFactorial(int n) {
        if (n <= 1)
            return 1;
        return n * recFactorial(n - 1);
    }

    static public double HarmonicSumRec(int n) {
        if (n == 1)
            return 1.0;
        return 1 / (double) n + HarmonicSumRec(n - 1);
    }

    static double HarmonicSumIter(double n) {
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum = sum + (1 / i);
        }
        return sum;
    }

    static int Max(int arr[], int i) {
        int max;
        if (arr.length == i)
            return arr[0];
        max = Max(arr, i + 1);
        if (arr[i] > max)
            max = arr[i];
        return max;
    }

    static int Min(int arr[], int i) {
        if (arr.length == i)
            return arr[0];
        int min = Min(arr, i + 1);
        if (arr[i] < min)
            min = arr[i];
        return min;
    }

    static int digSumRec(int x) {
        int res;
        if (x == 0) {
            res = 0;
            return res;
        } else
            res = x % 10 + digSumRec(x / 10);
        return res;
    }


}
