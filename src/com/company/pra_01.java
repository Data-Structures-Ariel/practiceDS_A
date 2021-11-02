package com.company;

import java.util.*;


public class pra_01 {
    public static void q24() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.println("Enter Number for num1 and num2");
        int num1 = sc.nextInt(), num2 = sc.nextInt();
        while (flag) {
            System.out.println("Menu:");
            System.out.println("1-add\n2-sub\n3-div\n4-mul\n5-pow\n");
            int ch = sc.nextInt();
            flag = !flag;
            switch (ch) {
                case 1:
                    System.out.printf("%d", (num1 + num2));
                    break;
                case 2:
                    System.out.printf("%d", num1 - num2);
                    break;
                case 3:
                    System.out.printf("%.2f", num1 / num2);
                    break;
                case 4:
                    System.out.printf("%d", num1 * num2);
                    break;
                case 5:
                    System.out.printf("%d", Math.pow(num1, num2));
                    break;
                default:
                    System.out.printf("Sorry, Try again\n");
                    flag = !flag;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        q24();
    }
}