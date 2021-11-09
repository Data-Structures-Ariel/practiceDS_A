package com.company;

import java.util.Arrays;


public class pra_03 {


    public static void mergeSort(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);
    }

    //O(logn)
    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int middle = l + (r - l) / 2;
            mergeSort(arr, l, middle);
            mergeSort(arr, middle + 1, r);
            merge(arr, l, middle, r);
        }
    }

    //O(n)
    static void merge(int[] a, int l, int middle, int r) {
        int[] right = new int[r - middle];
        int[] left = new int[middle - l + 1];

        right = Arrays.copyOfRange(a, l, middle + 1);
        left = Arrays.copyOfRange(a, middle + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j])
                a[k++] = right[j++];
            else
                a[k++] = left[i++];
        }
        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }

    // O(n logn)
    public static void merge_sort(int[] a) {
        if (a.length > 1) {
            int[] first = new int[a.length / 2];
            int[] second = new int[a.length - a.length / 2];

            for (int i = 0; i < a.length / 2; i++)
                first[i] = a[i];
            for (int i = 0; i < a.length - a.length / 2; i++)
                second[i] = a[a.length / 2 + i];

            merge_sort(first);
            merge_sort(second);

            int[] temp = merge(first, second);
            for (int i = 0; i < a.length; i++)
                a[i] = temp[i];
        }
    }

    // O(n+m)
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)//b=10 , a=8
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];

        while (i < a.length)
            c[k++] = a[i++];
        while (j < b.length)
            c[k++] = b[j++];

        return c;
    }
}





