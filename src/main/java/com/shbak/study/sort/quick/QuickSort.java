package com.shbak.study.sort.quick;

import javax.swing.*;

public class QuickSort {

    public static void swap(int[] array, int index_1, int index_2) {
        int tmp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = tmp;
        System.out.println("================ SWAP ===================");
        System.out.println("index_1 : " + index_1 + " index_2 : " + index_2);
        System.out.println("=========================================");
    }
    public static void quickSort(int[] array, int first_index, int last_index) {
        int pivot = array[(first_index + last_index) / 2];
        int pl = first_index;
        int pr = last_index;

        System.out.println("====================== quick sort information ======================");
        System.out.println("pivot : " + pivot);
        System.out.println("pl : " + pl);
        System.out.println("pr : " + pr);
        printAllArray(array);
        System.out.println("====================================================================");

        do {
            while(array[pl] < pivot) pl++;
            while(array[pr] > pivot) pr--;
            if(pl <= pr) swap(array, pl++, pr--);
        } while (pl<= pr);

        if(first_index < pr) quickSort(array, first_index, pr);
        if(pl < last_index) quickSort(array, pl, last_index);
    }

    public static void printAllArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 7, 9, 11, 4, 3};
        quickSort(array, 0, array.length -1 );
        printAllArray(array);
    }
}
