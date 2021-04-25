package com.shbak.study.array;

public class Reverse {
    /**
     *
     * @param array
     */
    static void init_int_array(int[] array) {
        System.out.println("Array initialize start");
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println("Array initialize end");
    }

    /**
     *
     * @param array
     * @param idx_1
     * @param idx_2
     */
    static void swap(int[] array, int idx_1, int idx_2) {
        int tmp;
        tmp = array[idx_1];
        array[idx_1] = array[idx_2];
        array[idx_2] = tmp;

        System.out.printf("array[%d] and array[%d] is changed%n", idx_1, idx_2);
        print_all_array_without_line_change(array);
    }

    /**
     *
     * @param array
     */
    public static void reverse(int[] array) {
        System.out.printf("reverse all array element start\n");
        for (int i = 0; i < array.length/2; i++) {
            swap(array, i, array.length - i - 1);
        }
        System.out.printf("reverse all array element end\n");
    }

    /**
     *
     * @param array
     */
    public static void print_all_array(int[] array){
        System.out.printf("All array print start\n");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d] : %d\n", i, array[i]);
        }
        System.out.printf("All array print done\n");
    }

    /**
     *
     * @param array
     */
    public static void print_all_array_without_line_change(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println("");
    }

    /**
     *
     * @param a
     * @param b
     */
    public static void copy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
    }

    /**
     *
      * @param a
     * @param b
     */
    public static void rcopy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - i -1];
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int SIZE = 9;
        int[] array = new int[SIZE];
        // initialize array
        init_int_array(array);
        print_all_array(array);
        swap(array, 1, 4);
        print_all_array(array);
        reverse(array);
        print_all_array(array);
    }
}
