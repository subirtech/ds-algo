package com.array;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {


    public static int removeDuplicates(int[] nums) {
        boolean flag = false;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (flag && nums[i-1] == nums[j] )
                continue;

            nums[i++] = nums[j];
            flag = true;

        }
        return i;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int index=removeDuplicates(nums);
        for(int i=0;i<index;i++)
        {
            System.out.print(nums[i]+" ");
        }

    }


}
