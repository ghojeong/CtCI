# Coin Change DP 문제

## [322. Coin Change](https://leetcode.com/problems/coin-change/)

```java
class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE - 2);
    Arrays.sort(coins);

    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i < coins[j]) {
          break;
        }
        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
      }
    }

    if (dp[amount] == Integer.MAX_VALUE - 2) {
      return -1;
    }
    return dp[amount];
  }
}
```

## [518. Coin Change 2](https://leetcode.com/problems/coin-change-2/)

```java
class Solution {
  public int change(int amount, int[] coins) {
    int dp[] = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }

    return dp[amount];
  }
}
```
