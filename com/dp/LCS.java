package com.dp;

/**
 * Longest Common Subsequence
 */
public class LCS {
    /**
     * Complexity:=> O(2^(m*n))
     * Recursive approach to get lcs length
     *
     * @return
     */
    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int maxLength = 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            maxLength = 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            maxLength = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
        return maxLength;
    }

    public static void main(String[] args) {
  /*      String s1 = "ABCAB";
        String s2 = "AECB";*/
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        StringBuilder strb = new StringBuilder();
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }
}
