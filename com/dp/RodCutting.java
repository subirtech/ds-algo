package com.dp;

public class RodCutting {

    /*Recursin Sollution
    Time Complexity of recursive solution is O(2^n)
     */
    public static int rodCut(int n, int[] cost) {

        if (n <= 0)
            return 0;
        int finalCost = Integer.MIN_VALUE;

        for (int i = 0; i < cost.length; i++) {
            if ((n - (i + 1) >= 0)) {
                int cutCost = cost[i] + rodCut((n - (i + 1)), cost);
                finalCost = Integer.max(finalCost, cutCost);
            }
        }
        return finalCost;
    }

    /**
     * Rodcutting problem using Dynamic programming.
     * Complexity O(n^2)
     * @param n
     * @param cost
     * @return
     */
    public static int rodCut_DP(int n, int[] cost) {
     int dp[]=new int[n+1];
     for(int i=1;i<=n;i++){
         for(int j=0;j<i;j++){
             dp[i]=Math.max(dp[i],cost[j]+dp[i-j-1]);
         }
     }
      return dp[n];
    }

    public static void main(String[] args) {
         int cost[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        //int cost[] = new int[]{1, 5, 6, 9, 11, 12, 14, 16};
        System.out.println("[Recursive] Final Cost:=>" + rodCut(8, cost));
        System.out.println("[DP] Final Cost:=>" + rodCut_DP(8, cost));
    }

}
