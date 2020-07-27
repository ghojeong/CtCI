# [925.Long Pressed Name](https://leetcode.com/problems/long-pressed-name/)

```java
class Solution {
  public int[] toCharNum(String str) {
    char[] charArr = str.toCharArray();
    int len = charArr.length;
    int[] charNum = new int[len + len]; // 짝수번쨰: char, 홀수번째: char 갯수

    int idx = -1;
    char currChar = 0;
    for (int i=0; i<len; i++) {
      if (currChar != charArr[i]) {
        currChar = charArr[i];
        charNum[++idx] = currChar;
        charNum[++idx] = 1;
      } else {
        charNum[idx]++;
      }
    }
    return charNum;
  }

  public boolean isLongPressedName(String name, String typed) {
    int[] nameNum = toCharNum(name);
    int[] typedNum = toCharNum(typed);

    int idx = 0;
    while (idx < nameNum.length) {
      if (nameNum[idx] != typedNum[idx++]) {
        return false;
      }
      if (nameNum[idx] > typedNum[idx++]) {
        return false;
      }
    }
    if (idx != typedNum.length && typedNum[idx] != 0) {
      return false;
    }
    return true;
  }
}
```
