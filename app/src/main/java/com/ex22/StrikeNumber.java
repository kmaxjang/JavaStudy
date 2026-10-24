package com.ex22;
/*
    out   1
    0s 1b 3
    0s 2b 3
    0s 3b 1
    1s 1b 6
    1s 2b 3
    2s    3
    3s    1
*/

public class StrikeNumber {

  private final int[] number = new int[3];

  public static StrikeNumber create(int n1, int n2, int n3) {
    if (!isRange(n1)
        || !isRange(n2)
        || !isRange(n3)
        || n1 == n2 //
        || n2 == n3 //
        || n3 == n1) {
      return null;
    }
    return new StrikeNumber(n1, n2, n3);
  }

  public static boolean isRange(int n) {
    return n > 0 && n < 10;
  }

  private StrikeNumber(int n1, int n2, int n3) {
    number[0] = n1;
    number[1] = n2;
    number[2] = n3;
  }

  public String number() {
    return "" + number[0] + number[1] + number[2];
  }

  public String judgment(StrikeNumber sn) {
    int strike = 0, ball = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (number[i] == sn.number[j]) {
          if (i == j) {
            strike++;
          } else {
            ball++;
          }
          break;
        }
      }
    }
    if (strike == 0 && ball == 0) return "Out";
    if (strike == 3) return "Homerun";
    return strike + "S " + ball + "B";
  }
}
