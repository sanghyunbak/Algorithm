package com.shbak.study.util;

public class ArrayUtil {
    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void swap(int[] array, int index_1, int index_2) {
        int tmp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = tmp;
    }
}
