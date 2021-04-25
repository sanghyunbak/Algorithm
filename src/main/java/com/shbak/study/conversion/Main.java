package com.shbak.study.conversion;

public class Main {

    final static String NUMBER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String convNumberWithBase(int number, int base) {

        /**
         * initialize variables
         */
        int x;
        int r;
        int ptr = 0;
        String result = "";

        /**
         * loop for main process of conversion
         */
        x = number;
        do {
            r = x % base;
            x = x / base;
            result = NUMBER.charAt(r) + result;
        } while(x != 0);

        return result;
    }

    public static void main(String[] args) {
        int NUM = 100;
        int R = 16;

        String r = convNumberWithBase(NUM, R);
        System.out.printf("Num : %d, R : %d : Result : %s\n", NUM, R, r);
    }
}
