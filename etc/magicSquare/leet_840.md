# [840. Magic Squares In Grid](https://leetcode.com/problems/magic-squares-in-grid/)

```java
class Solution {
  public boolean checkMagicSquare(int offsetI, int offsetJ, int[][] grid) {
    int n = 3;
    int sum = 15;
    int sum2 = 0;
    HashSet<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < n; i++) {
      sum2 = 0;
      for (int j = 0; j < n; j++) {
        int el = grid[offsetI + i][offsetJ + j];
        if (el > 9 || el < 1) {
          return false;
        }
        if (set.contains(el)) {
          return false;
        }
        set.add(el);
        sum2 += el;
      }
      if (sum != sum2) {
        return false;
      }
    }

    for (int j = 0; j < n; j++) {
      sum2 = 0;
      for (int i = 0; i < n; i++) {
        sum2 += grid[offsetI + i][offsetJ + j];
      }
      if (sum != sum2) {
        return false;
      }
    }

    sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum2 += grid[offsetI + i][offsetJ + i];
    }
    if (sum != sum2) {
      return false;
    }

    sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum2 += grid[offsetI + i][offsetJ + n - 1 - i];
    }
    if (sum != sum2) {
      return false;
    }

    return true;
  }

  public int numMagicSquaresInside(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int cnt = 0;

    for (int i = 0; i <= n - 3; i++) {
      for (int j = 0; j <= m - 3; j++) {
        System.out.println(i + " " + j);
        if (checkMagicSquare(i, j, grid)) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
```
