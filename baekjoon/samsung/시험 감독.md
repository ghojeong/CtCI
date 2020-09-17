# [시험 감독](https://www.acmicpc.net/problem/13458)

주의점! cnt 는 반드시 long 이어야 한다.

입력되는 범위를 잘보고 실제 크기를 가늠할 줄 알아야 한다.

```java
import java.util.*;
import java.io.*;

class Main {
  static BufferedReader br;
  static BufferedWriter bw;

  static void initIO() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  static void closeIO() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    initIO();

    int n = Integer.parseInt(br.readLine()); // n개의 시험장
    int[] a = new int[n]; // i번째 시험장에 있는 응시자 수는 a[i]
    int b; // 총감독관이 한 시험장에서 감시할 수 있는 응시자 수
    int c; // 부감독관이 한 시험장에서 감시할 수 있는 응시자 수

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    long cnt = n;
    for (int i = 0; i < n; i++) {
      int aMinusB = a[i] - b;
      if (aMinusB > 0) {
        cnt += aMinusB / c;
        if (aMinusB % c != 0) {
          cnt++;
        }
      }
    }

    bw.write(cnt + "");
    closeIO();
  }
}

```
