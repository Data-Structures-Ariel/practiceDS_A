package com.company;

public class pra_04 {
    public static void main(String[] args) {
        int[] a = {20, 5, 7, 3, 2, 7, 9, 12, 357, 24, 68};
        System.out.println("Factorial is "+Factorial(10));
        System.out.printf("Harmonic rec = %.2f\n", HarmonicSumRec(2));
        System.out.printf("Harmonic iter = %.2f\n", HarmonicSumIter(2));
        System.out.println("Min number is " + Min(a));
        System.out.println("Max number is " + Max(a));
        System.out.println("Sum of digit is " + digSumRec(123456));
        System.out.println("Revers number is "+numRev(12345));
        DrawT(10);
    }
    static public int Factorial(int n) {
        return recFactorial(Math.abs(n));
    }
    static private int recFactorial(int n) {
        if (n <= 1)
            return 1;
        int ans = recFactorial(n - 1);
        return n * ans;
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
    static public int Max(int arr[]) {
        return Max(arr, 0);
    }
    static private int Max(int arr[], int i) {
        int max;
        if (arr.length == i)
            return arr[0];
        max = Max(arr, i + 1);
        if (arr[i] > max)
            max = arr[i];
        return max;
    }
    public static int Min(int arr[]) {
        return Min(arr, 0);
    }
    static private int Min(int arr[], int i) {
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
    //12345 --> num=12345
    //1234 -->num=1234
    //123 -->num=123
    //12 -->num=12
    //1 --> num=1
    //0
    //  10^0 10^1   10^2   10^3    10^4
    //1*1   2*10  3*100  4*1000 5*10000
    //1+20+300+4000+50000=54321
    static int numRev(int num) {
        if (num == 0)
            return 0;
        num = (int) ((num % 10) * (Math.pow(10, (int) Math.log10(num)))) + numRev(num / 10);
        return num;
    }


    static void DrawT(int n) {
        if (n == 1) {
            System.out.println("*");
            return;
        }
        DrawT(n - 1);
        for (int i = 0; i < n; i++)
            System.out.printf("*");
        System.out.println("");
    }

}
