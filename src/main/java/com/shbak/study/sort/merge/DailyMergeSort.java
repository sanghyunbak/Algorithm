package com.shbak.study.sort.merge;

import com.shbak.study.util.ArrayUtil;

public class DailyMergeSort {
    public static void mergeSort(int[] array, int first_index, int last_index) {
        int mid_index =  (first_index + last_index) / 2;


        if(first_index < last_index) {
            mergeSort(array, first_index, mid_index);
            mergeSort(array, mid_index + 1, last_index);
            merge(array, first_index, mid_index, last_index);
        }

   }
    public static void merge(int[] array, int first_index, int mid_index, int last_index) {
        int[] tmp = new int[array.length];
        int index = first_index;
        for (int i = first_index; i <= last_index; i++) {
            tmp[i] = array[i];
        }

        int pl = first_index;
        int pr = mid_index + 1;

        System.out.println("================== merge ===================");
        System.out.println("first_index: " + first_index);
        System.out.println("mid_index: " + mid_index);
        System.out.println("last_index: " + last_index);
        ArrayUtil.printIntArray(array);
        System.out.println("============================================");

        while(pl <= mid_index && pr <= last_index) {
            if(tmp[pl] <= tmp[pr]) {
                array[index++] = tmp[pl++];
            }else {
                array[index++] = tmp[pr++];
            }
        }

        if(pl <= mid_index) {
            for (int i = pl; i <= mid_index; i++) {
                array[index++] = tmp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 14, 7, 5, 3, 10, 19};
        mergeSort(array, 0, array.length-1);
        ArrayUtil.printIntArray(array);
    }

}