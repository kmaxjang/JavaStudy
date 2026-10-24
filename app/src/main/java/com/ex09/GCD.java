package com.ex09;

public class GCD {

  // 최대공약수
  public static int gcd(int a, int b) {
    int max = Math.max(Math.abs(a), Math.abs(b));
    int min = Math.min(Math.abs(a), Math.abs(b));
    int temp = 0;
    while (min != 0) {
      temp = min;
      min = max % min;
      max = temp;
    }
    return max;
  }
  
  // 최소공배수
  public static int lcm(int a, int b) {
    return Math.abs(a * b) / gcd(a, b);
  }
}
