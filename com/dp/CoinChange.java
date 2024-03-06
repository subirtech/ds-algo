package com.dp;

public class CoinChange {

    //recursion approach
    // Complexity O(n^m)
    public static int coinChange(int n, int[] coins) {
        if (n == 0)
            return 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (n >= coins[i]) {
                int ans = coinChange(n - coins[i], coins);
                if (ans != Integer.MAX_VALUE && count > (ans + 1))
                    count = ans + 1;
            }
        }
        return count;
    }

    //Dynamic Programming approach
    // Complexity O(nm)
    public static int coinChangeDP(int n, int[] coins, int[] dp) {
        if (n == 0)
            return 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (n >= coins[i]) {
                if (dp[n - coins[i]] != -1) {
                    return dp[n - coins[i]];
                } else {
                    int ans = coinChangeDP(n - coins[i], coins, dp);
                    if (ans != Integer.MAX_VALUE && count > (ans + 1)) {
                        count = ans + 1;
                        dp[n - coins[i]] = count;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int n = 99;
        int coins[] = new int[]{7, 5, 1};
        long start=System.currentTimeMillis();
        System.out.println("Coin Change Result:=>" + coinChange(n, coins));
        System.out.println("Execution time for recursive approach :=>" + (System.currentTimeMillis()-start));

        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;

        start=System.currentTimeMillis();
        System.out.println("[Dynamic Programming]Coin Change Result:=>" + coinChangeDP(n, coins,dp));
        System.out.println("Execution time for Dynamic Programming approach :=>" + (System.currentTimeMillis()-start));
    }

}
