package com.ex21;

import java.util.Arrays;
import static com.ex01.Massge.*;

final class MainClass {
// 123 수렴 패턴
 public static int count(int number) {
  int even = 0;
  int total = 0;
  
if(number == 0) return 101;

  while (number > 0) {
   if (isEven(number)) {
    even++;
   }
   total++;
   number /= 10;
  }

  return concat(even,total-even, total);
 }
 
 // 10배수 테이블
 public static final int[] POW10 = {
  1,10,100,1000,10000,
  100000,1000000,10000000,
  100000000,1000000000
 };
// ===== 거듭제곱 ===== 
 // 10거듭제곱
 // 
 public static int pow10(int n){
   return pow10Array(n);
 }
 
 // 테이블 접근형
 private static int pow10Array(int n) {
  return POW10[n];
 }
 
 // 연산형
 private static int pow10Calc(int n) {
  int result = 1;
  while (n-- > 0) result *= 10;
  return result;
 }
 
 // 자리수 길이
 // lengthWhile, lengthFor, lengthIf
 public static int length(int n){
   return lengthIf(n);
 }
 
 // while문형
 private static int lengthWhile(int n) {
 n = Math.abs(n);
  if (n < 10) return 1;
n /= 10;
  int len = 1;
  while (n != 0) {
   len++;
   n /= 10;
  }
  return len;
 }
 
 // for문형
 private static int lengthFor(int n){
   n = Math.abs(n);
   for(int len =1; len < POW10.length; len++){
     if(n < POW10[len]) return len;
   }
   return 10;
 }
 
 // if문형
 private static int lengthIf(int n) {
 n = Math.abs(n);

 if (n < 10) return 1;
 else if (n < 100) return 2;
 else if (n < 1000) return 3;
 else if (n < 10000) return 4;
 else if (n < 100000) return 5;
 else if (n < 1000000) return 6;
 else if (n < 10000000) return 7;
 else if (n < 100000000) return 8;
 else if (n < 1000000000) return 9;
 return 10;
}

 // 숫자 이어붙이기 (가변 인자) 1+2 = 12
 public static int concat(int... nums) {
  int result = 0;

  for (int n : nums) {
   result = result * POW10[length(n)] + n;
  }

  return result;
 }

 // ===== 홀짝 판별 =====

 public static boolean isEven(int n) {
  return (n & 1) == 0;
 }

 public static boolean isOdd(int n) {
  return (n & 1) != 0;
 }
 
 //자리별 합산 
public static int digitSum(int n) {
 int sum = 0;
 n = Math.abs(n);

 while (n != 0) {
  sum += n % 10;
  n /= 10;
 }
 return sum;
}

 // ===== 배수 판별 =====

 public static boolean isMultipleOf3(int n) {

  return digitSum(n) % 3 == 0;
 }

 public static boolean isMultipleOf9(int n) {

  return digitSum(n) % 9 == 0;
 }

 public static boolean isMultipleOf5(int n) {
  int d = n % 10;
  return d == 0 || d == 5;
 }

 public static boolean isMultipleOf10(int n) {
  return n % 10 == 0;
 }

 // ===== 2의 거듭제곱 =====

 public static boolean isPowerOf2(int n) {
  return n > 0 && (n & (n - 1)) == 0;
 }

 // ===== 소수 =====

 public static boolean isPrime(int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;

  for (int i = 5; i * i <= n; i += 6) {
   if (n % i == 0 || n % (i + 2) == 0)
    return false;
  }

  return true;
 }

 // ===== 자리수 처리 =====

 public static int reverse(int n) {
  int result = 0;

  while (n != 0) {
   result = result * 10 + n % 10;
   n /= 10;
  }

  return result;
 }

 public static int digitAt(int n, int index) {
  // index: 0 = 마지막 자리
  while (index-- > 0) {
   n /= 10;
  }
  return n % 10;
 }
 
 public static int[] digits(int n){
 if(n < 10) return new int[]{n};
 
   int[] digits = new int[10];
  int len = 9;
  while (n != 0) {
  digits[len] = n % 10;
   len--;
   n /= 10;
  }
  return Arrays.copyOfRange(digits,len+1,10);
 }
 
 public static int[] _digits(int n){
   if(n < 10) return new int[]{n};
   int len = length(n);
   int[] digits = new int[len];
  len--;
  while (n != 0) {
  digits[len] = n % 10;
   len--;
   n /= 10;
  }
  return digits;
 }

 public static void main(String[] args) {
  print("123");

  int start = 0; //Integer.MAX_VALUE;
  print(start);
  while (start != 123) {
   start = MainClass.count(start);
   print(start);
  }
  
  print(digits(1123250));
  print(_digits(1123250));
  
  int range = 10;
  for(int a = range; a < 10+range; a++){
    print(a);
  }
  
  for(int a=0; a< 10; a++){
    print(a+range);
  }
 }
}