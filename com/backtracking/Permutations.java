package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 46. Permutations
 */
public class Permutations {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void permute(int[] nums, List<Integer> temp) {
        if (nums.length == temp.size()) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            permute(nums, temp);
            temp.remove(temp.size() - 1);

        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums, new ArrayList<Integer>());
        System.out.println("Result==>"+result);
    }
}
