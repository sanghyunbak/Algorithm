package com.shbak.study.sort.merge;

public class RecursiveMergeSort {
//        private int[] array;
//        private int[] tmp;
//        private int start;
//        private int end;
//
//        public RecursiveMergeSort(int[] array) {
//            this.array = array;
//            this.start = 0;
//            this.end = array.length - 1;
//            this.tmp = new int[this.end];
//        }

    /**
     * merge 하는 두 Array는 인접해 있다고 가정
     * @param array
     * @param tmp
     * @param start
     * @param end
     */
    public static void mergeSort(int[] array, int[] tmp, int start, int end) {
        if (end > start) {
            int mid = (end + start) / 2;
            System.out.println("===========mergeSort=============");
            System.out.println("start : " + start);
            System.out.println("end : " + end);
            mergeSort(array, tmp, start, mid);
            mergeSort(array, tmp, mid+1, end);
//            merge(array, tmp, start, mid, mid+1, end);
            merge_new(array, tmp, start, mid, end);
        }
    }

    /**
     * tmp is original data
     * array is change
     * @param array
     * @param tmp
     * @param start_left
     * @param end_left
     * @param start_right
     * @param end_right
     */
    public static void merge (int[] array, int[] tmp, int start_left, int end_left, int start_right, int end_right) {
        int index = 0;
        int start = start_left;

        System.out.println("--------------------------- merge ---------------------------");
        System.out.println("start_left : " + start_left);
        System.out.println("end_left : " + end_left);
        System.out.println("start_right : " + start_right);
        System.out.println("end_right : " + end_right);
        System.out.println("-------------------------------------------------------------");

        while(start_left <= end_left && start_right <= end_right) {
            if (array[start_left] > array[start_right]) {
                tmp[index++] = array[start_right];
                start_right++;
            } else {
                tmp[index++] = array[start_left];
                start_left++;
            }
        }

        System.out.println("------------------ start end left right ------------------");
        System.out.println("start_left : " + start_left);
        System.out.println("end_left : " + end_left);
        System.out.println("start_right : " + start_right);
        System.out.println("end_right : " + end_right);
        System.out.println("----------------------------------------------------------");

        if(start_left <= end_left) {
            for (int i = start_left; i <= end_left ; i++) {
                tmp[index++] = array[i];
            }
        } else {
            for (int i = start_right; i <= end_right ; i++) {
                tmp[index++] = array[i];
            }
        }

        System.out.println("==================== tmp =======================");
        arrayPrint(tmp);
        System.out.println("=======================---=======================");

        for (int i = 0; i <= end_right - start; i++) {
            array[start + i] = tmp[i];
        }
        System.out.println("==================== array =======================");
        arrayPrint(array);
        System.out.println("=================================================");
    }

    public static void merge_new(int[] array, int[] tmp, int start, int mid, int end) {
        // copy original sorted array to tmp
        for (int i = 0; i < array.length ; i++) {
            tmp[i] = array[i];
        }

        int left_point_start = start;
        int left_point_end = mid;
        int right_point_start = mid +1;
        int right_point_end = end;

        System.out.println("================== INFO ================");
        System.out.println("left_point_start : " + left_point_start);
        System.out.println("left_point_end : " + left_point_end);
        System.out.println("right_point_start : " + right_point_start);
        System.out.println("right_point_end : " + right_point_end);
        System.out.println("========================================");

        while ( left_point_start <= left_point_end && right_point_start <= right_point_end ) {
            if (tmp[left_point_start] > tmp[right_point_start]) {
                array[start++] = tmp[right_point_start++];
            } else {
                array[start++] = tmp[left_point_start++];
            }
        }


        System.out.println("================== INFO PHASE 1================");
        System.out.println("left_point_start : " + left_point_start);
        System.out.println("left_point_end : " + left_point_end);
        System.out.println("right_point_start : " + right_point_start);
        System.out.println("right_point_end : " + right_point_end);
        System.out.println("========================================");
        System.out.println("================== MERGE PHASE1 ARRAY ================");
        arrayPrint(array);
        System.out.println("======================================================");

        System.out.println("================== TMP ARRAY ================");
        arrayPrint(tmp);
        System.out.println("======================================================");

        if (left_point_start > left_point_end) { //left side of array is sorting done
            while (right_point_start <= right_point_end) {
                array[start++] = tmp[right_point_start++];
            }
        } else {
            while (left_point_start <= left_point_end) {
                array[start++] = tmp[left_point_start++];
            }
        }

        System.out.println("================== MERGE PHASE2 ARRAY ================");
        arrayPrint(array);
        System.out.println("======================================================");
    }

    public static void arrayPrint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 45, 2, 5, 10, 4, 88, 3};
        int[] tmp = new int[array.length];
        System.out.println("==================== ORIGIN ======================");
        arrayPrint(array);

        RecursiveMergeSort.mergeSort(array, tmp, 0, array.length - 1);
        System.out.println("==================== RESULT ======================");
        arrayPrint(array);
    }
}
