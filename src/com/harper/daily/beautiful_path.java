package com.harper.daily;

/**
 * Created by harperkoo on 1/17/17.
 * https://www.hackerrank.com/challenges/beautiful-path?h_r=internal-search
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class beautiful_path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] c = new int[m];
        int[] u = new int[m];
        int[] v = new int[m];
        ArrayList<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            e.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
            c[i] = sc.nextInt();
            e.get(u[i]).add(i);
            e.get(v[i]).add(i);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 1; i < 1024; i++) {
            ArrayList<Integer> q = new ArrayList<Integer>();
            boolean[] added = new boolean[n+1];
            q.add(a);
            added[a] = true;
            while (!q.isEmpty()) {
                int next = q.remove(0);
                for (int edge : e.get(next)) {
                    if ((c[edge]|i)==i) {
                        if (u[edge] == b || v[edge] == b) {
                            System.out.println(i);
                            return;
                        }
                        if (u[edge]==next) {
                            if (!added[v[edge]]) {
                                added[v[edge]] = true;
                                q.add(v[edge]);
                            }
                        } else if (v[edge]==next) {
                            if (!added[u[edge]]) {
                                added[u[edge]] = true;
                                q.add(u[edge]);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
