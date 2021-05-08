package com.shbak.study.sort.merge;

public class DailyTrial {
    public static void mergeSort(int[] array, int index_start, int index_last) {
        int index_mid = (index_last + index_start) / 2;

        if(index_last > index_start) {
            System.out.println("================== mergeSort function =====================");
            System.out.println("index_start: " + index_start);
            System.out.println("index_last : " + index_last);
            System.out.println("index_mid: " + index_mid);

            mergeSort(array, index_start, index_mid);
            mergeSort(array, index_mid + 1, index_last);
            merge(array, index_start, index_mid, index_last);
        }
    }

    public static void merge(int[] array, int index_start, int index_mid, int index_last) {
        int[] tmp = new int[array.length];
        // copy all elements to tmp variable
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }

        int pl = index_start;
        int pr = index_mid + 1;
        int index = index_start;

        while(pl <= index_mid && pr <= index_last) {
            if(tmp[pl] > tmp[pr]) {
                array[index++] = tmp[pr++];
            } else {
                array[index++] = tmp[pl++];
            }
        }

        if(pl <= index_mid) {
            for (int i = 0; i <= index_mid - pl; i++) {
                array[index + i] = tmp[pl+i];
            }
        }
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] array = {1, 7, 8, 6, 14, 3, 5, 4};
        printArray(array);
        mergeSort(array, 0, array.length - 1);
        printArray(array);
    }
}
