package com.dp;

/**
 * 0/1 knapsack problem
 */
public class Knapsack {


    /**
     * Recursive approach of knapsack problem. Time complexity is O(2^n). N is length of cost or weight array.
     *
     * @param remainingWeight
     * @param weight
     * @param cost
     * @param index
     * @return
     */
    public static int knapSack(int remainingWeight, int[] weight, int[] cost, int index) {
        if (remainingWeight == 0 || index == weight.length || weight[index] > remainingWeight)
            return 0;

        int maxProfit = Integer.MIN_VALUE;

        int costWithWeight = cost[index] + knapSack(remainingWeight - weight[index], weight, cost, index + 1);
        int costWithOutWeight = knapSack(remainingWeight, weight, cost, index + 1);
        maxProfit = Integer.max(costWithWeight, costWithOutWeight);

        return maxProfit;
    }

    /**
     * Dynamic Programming Approach . Complexity O(totalCost*NumberOfWeights)
     *
     * @param totalWeight
     * @param weight
     * @param cost
     * @return
     */
    public static int knapSackDP(int totalWeight, int[] weight, int[] cost) {
        int[][] dp = new int[weight.length + 1][totalWeight + 1];
        for (int j = 0; j <= totalWeight; j++)
            dp[0][j] = 0;
        for (int i = 0; i <= weight.length; i++)
            dp[i][0] = 0;

        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= totalWeight; j++)
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], cost[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
        }

       /* for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/


        return dp[weight.length][totalWeight];
    }


    public static void main(String[] args) {
       /* int totalWeight = 10;
        int[] weight = new int[]{1, 3, 4, 6};
        int[] cost = new int[]{20, 30, 10, 50};*/

        /*int totalWeight=6;
        int[] weight=new int[]{1,2,3};
        int[] cost=new int[]{10,15,40};*/

        int totalWeight = 50;
        int[] weight = new int[]{10, 20, 30};
        int[] cost = new int[]{60, 100, 120};


        System.out.println("Max Profit:=>" + knapSack(totalWeight, weight, cost, 0));
        System.out.println("Max Profit DP:=>" + knapSackDP(totalWeight, weight, cost));


    }
}
