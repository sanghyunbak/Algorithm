package com.shbak.study.search.binary;

import com.sun.net.httpserver.Headers;

import java.util.Arrays;
import java.util.Comparator;

class CustomComparator {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER =
                new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return Integer.compare(d1.height, d2.height);
            }
        }
    }

    public static void main(String[] args) {
        /**
         * it is ordered by height
         */
        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("이수민", 175, 2.0)
        };

        int idx = Arrays.binarySearch(x, new PhyscData("", 168, 0.0), PhyscData.HEIGHT_ORDER);
        if (idx < 0) {
            System.out.println("Cannot found idx : " + idx);
        } else {
            System.out.println("idx : [" + idx + "]");
            System.out.println("data : [" + x[idx] + "]");
        }
    }
}

