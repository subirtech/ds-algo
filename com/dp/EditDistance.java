package com.dp;

public class EditDistance {

    /**
     * Edit distance using recursive approach
     * Time Complexity: O(3^m)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int edit(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            int l = m == 0 ? n : m;
            return l;
        }
        int length = 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            length = edit(s1, s2, m - 1, n - 1);
        else
            length = 1 + Math.min(Math.min(edit(s1, s2, m, n - 1), edit(s1, s2, m - 1, n)), edit(s1, s2, m - 1, n - 1));
        return length;
    }

    /**
     * Edit distance using Dynamic Programming. Time Comlexity O(m*n)
     * @param s1
     * @param s2
     * @return
     */
    public static int editDP(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++)
            dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++)
            dp[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }

            }
        }
      /*  for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {

        /*String s1 = "DOG";
        String s2 = "DIG";*/
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println("Edit Distance:=>" + edit(s1, s2, s1.length(), s2.length()));
        System.out.println("Edit Distance DP:=>" + editDP(s1, s2));
    }
}
