package com.search;

/**
 *This problem can be solved using brute force approach by merging two sorted arrays .Complexity- O(m+n)
 * This issue can be resolved with two pointers. Complexity O(m+n)
 * 4. Median of Two Sorted Arrays
 */
public class MedianSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = len1;
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MAX_VALUE;
        int mid1 = Integer.MIN_VALUE;
        int mid2 = Integer.MIN_VALUE;
        ;
        int left = (len1 + len2 + 1) / 2;
        while (low <= high) {
            mid1 = (low + high) / 2;
            mid2 = left - mid1;
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;

            if (mid1 < len1)
                r1 = nums1[mid1];
            if (mid2 < len2)
                r2 = nums2[mid2];

            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if ((l1 <= r2) && (l2 <= r1)) {
                if ((len1 + len2) % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((Math.max(l1, l2)) + (Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;


        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
      System.out.println( findMedianSortedArrays(nums1, nums2));
    }
}
