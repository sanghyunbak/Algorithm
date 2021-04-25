package com.shbak.study.search.binary;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UsingJavaArraysBinarySearch {
    final static int ELEMENT_NUM = 10;
    final static int [] arrays = {1,2,3,4,5,6,7,8,9,10};
    final static int key = -3;

    public static void main(String[] args) {
        int idx = Arrays.binarySearch(arrays, key);
        if (idx < 0) {
            System.out.println("have no index, key[" + key + "]");
            System.out.println("insert point is : [" + idx + "]");
        }
        else {
            System.out.println("index : [" + idx + "]");
        }
    }
}
