package com.shbak.study.sort.quick;

import com.shbak.study.util.StringUtil;

public class DailyQuickSort {
    public static void swap (int[] array, int index_1, int index_2) {
        int tmp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = tmp;
    }
    public static void quickSort(int[] array, int start, int end){
        int pivot = array[(start + end )/ 2];
        int pl = start;
        int pr = end;

        System.out.println("=================== quick Sort ==================");
        System.out.println("start_index : " + start);
        System.out.println("end_index : " + end );
        System.out.println("pivot : " + pivot);
        StringUtil.printIntArray(array);
        System.out.println("=================================================");
        while(pl <= pr) { // equal comparison is important!!, if not `
            while(array[pl] < pivot) pl++;
            while(array[pr] > pivot) pr--;

            if(pl <= pr)
                swap(array, pl++, pr--); //same value must be swap or increase pl, and decrease pr
        }

       if(start < pr) quickSort(array, start, pr);
       if(end > pl) quickSort(array, pl, end);

    }

    public static void main(String[] args) {
        int[] initial_array = {3, 1, 6, 10, 5, 7, 2, 19};
        quickSort(initial_array, 0, initial_array.length - 1);
        StringUtil.printIntArray(initial_array);
    }
}
