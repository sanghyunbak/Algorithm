package com.shbak.study.add;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        int N = 11;
        boolean isEven = (N % 2 == 0);

        if (isEven) {
            result = (N + 1) * N / 2;
        } else {
            result = N * (int)(N/2) + N;
        }
        System.out.println("result : " + result);

        System.out.println(sumof(2,5));
    }

    static int sumof(int a, int b) {
        int result = 0;

        if (a>b) {
            for (int i =b; i <= a; i++) {
                System.out.println("i : " + i);
                result  += i;
            }
        } else {
            for (int i =a; i <= b; i++) {
                System.out.println("i : " + i);
                result +=  i;
            }
        }

        System.out.println("result :" + result);
        return result;
    }
}