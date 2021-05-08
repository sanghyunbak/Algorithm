package com.shbak.study.sort.merge;

import com.shbak.study.util.ArrayUtil;

public class DailyPractice {
    public static void mergeSort(int[] array, int start_index, int end_index) {
        int mid_index = (start_index + end_index) / 2;

        if(start_index < end_index) {
            mergeSort(array, start_index, mid_index);
            mergeSort(array, mid_index + 1, end_index );
            merge(array, start_index, mid_index, end_index);
        }
    }

    /**
     * merge separated two array to one array
     * @param array
     * @param start_index
     * @param mid_index
     * @param end_index
     */
    public static void merge(int[] array, int start_index, int mid_index, int end_index) {


        int pl = start_index;
        int pr = mid_index + 1;
        int[] tmp = new int[array.length];
        int index = start_index;

        // use tmp array as merge size
        for (int i = start_index; i <= end_index; i++) {
            tmp[i] = array[i];
        }

        System.out.println("=================== merge information ===============");
        System.out.println("start_index : " + start_index);
        System.out.println("mid_index : " + mid_index);
        System.out.println("end_index : " + end_index);
        System.out.println("Array");
        ArrayUtil.printIntArray(array);
        System.out.println("TMP");
        ArrayUtil.printIntArray(tmp);
        System.out.println("=====================================================");

        while(pl <= mid_index && pr <= end_index) {
            if (tmp[pl] <= tmp[pr]) {
                array[index++] = tmp[pl++];
            } else {
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
        int[] initail_array = {1, 5, 7, 10, 6, 3, 2, 19};
        ArrayUtil.printIntArray(initail_array);
        mergeSort(initail_array, 0, initail_array.length - 1);
        ArrayUtil.printIntArray(initail_array);
    }
}
