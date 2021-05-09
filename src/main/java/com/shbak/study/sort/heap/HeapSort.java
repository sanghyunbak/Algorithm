package com.shbak.study.sort.heap;

import com.shbak.study.util.ArrayUtil;

public class HeapSort {
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];
        int child;
        int parent;

        for (parent = left; parent< (right + 1)/2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl +1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if(temp >= a[child]) {
                break;
            }
            a[parent] = a[child];
        }

        a[parent] = temp;
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n-1)/2; i >= 0 ; i--) {
            downHeap(a, i, n-1);
        }
        ArrayUtil.printIntArray(a);

        for (int i = n-1; i> 0; i--) {
            ArrayUtil.swap(a, 0, i);
            downHeap(a, 0, i-1);
        }
        ArrayUtil.printIntArray(a);
    }

    public static void main(String[] args) {
        int[] a = {7, 22, 5, 11, 32, 120, 68, 70};
        heapSort(a, a.length);
    }
}
