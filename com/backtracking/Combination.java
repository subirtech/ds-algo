package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private static void combine(int n, int k, int index, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList(temp));
            return;
        }

        for (int i = index; i <= n; i++) {
            temp.add(i);
            combine(n, k, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        combine(4, 2, 1, new ArrayList<Integer>(), result);
        System.out.println("Result:=>" + result);

    }
}
