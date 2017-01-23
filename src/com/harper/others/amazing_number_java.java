package com.harper.others;

import java.util.LinkedList;

/**
 * Created by harperkoo on 1/20/17.
 */
public class amazing_number_java {
    public static void main(String[] args) {
//        int[] a = {7, 6, 5, 3, 2, 1};
        int[] a = {1,5,2,4,3};
//        int[] a = {1, 2, 3, 4, 0, 0, 0, 1, 2, 3, 4, 1, 2, 3, 100, 0, 1, 2, 3, 4, 5, 6, 1, 101, 0, 0, 0, 0, 0, 0, 0,
//                3, 5, 7, 1, 2};

        System.out.println(amazingNumber(a));
    }

    public static int amazingNumber(int[] a) {
        int len = a.length;
        LinkedList<Interval> intervals = new LinkedList<>();

        // find all the intervals that if the array starts at any index in the interval, there will
        // be at least 1 element is amazing number
        for (int i = 0; i < len; i++) {
            if (a[i] >= len) continue;
            int start = (i+1) % len;
            int end = (len + (i - a[i])) % len;
            System.out.println(i + ": " + start + " - " + end);
            intervals.add(new Interval(start, end));
        }

        // now our problem has just become: "find the year that has the maximum number of people
        // alive"
        int[] count = new int[len];
        for (Interval i : intervals) {
            count[i.start]++;
            if (i.end+1 < count.length) count[i.end+1]--;
        }
        int max = 0;
        int counter = 0;
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            counter += count[i];
            if (counter > max) {
                max = counter;
                idx = i;
            }
        }

        return idx;
    }

    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
