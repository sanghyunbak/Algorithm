package com.shbak.study.search.quick;

public class QuickSort {
    public static void swap(int[] array, int index_1, int index_2) {
        System.out.println("============= SWAP =============");
        System.out.println("index_1 :" + index_1);
        System.out.println("index_2 :" + index_2);

        int tmp;
        tmp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = tmp;
    }

    public static void quickSort(int[] array, int start, int end){
        int pivot = array[(start + end)/2];
        int pl = start;
        int pr = end;
        System.out.println("================= quick sort info ===================");
        System.out.println("pl : " + pl);
        System.out.println("pr : " + pr);
        System.out.println("pivot : " + pivot);
        printAll(array);
        System.out.println("=====================================================");

        while(pl < pr) {
            while(pivot > array[pl] && pl <= end) pl++;
            while(pivot < array[pr] && pr >= start) pr--;
            System.out.println("========== if start =========");
            System.out.println("pl : " + pl);
            System.out.println("pr : " + pr);
            System.out.println("========== if end =========");
            if(pl < pr) swap(array, pl++, pr--); // important
        }

        if(start < pr) quickSort(array, start, pr);
        if(pl < end) quickSort(array, pl, end);
    }

    public static void printAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 7, 9, 11, 4, 3};
        System.out.println("===================== initial Array =====================");
        printAll(a);
        quickSort(a, 0, a.length - 1);
        System.out.println("===================== Sorting end Array =====================");
        printAll(a);
    }
}
