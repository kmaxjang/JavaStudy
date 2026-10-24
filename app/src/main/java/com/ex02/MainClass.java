package com.ex02;

import com.ex01.Direction;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    print("Java EX02 2024.08.10");
    int[] lotto = {1, 2, 3, 4, 5, 15};
    StringBuilder sb = new StringBuilder();

    for (int c = 0; c < 45; c++) {
    sb.append(c+"> ");
      for (int i = 0; i < lotto.length; i++) {
        lotto[i] = lotto[i]%45+1;
        sb.append(String.format("%2d ",lotto[i]));
      }
      sb.append("\n");
      }
      System.out.println(sb);
      
      long number=0;
      for(int n: lotto){
        number = number*100+n;
      }
      print("Integer : "+ number);
      
      int len = (int)Math.log10(number)+1;
      int[] lotto2 = new int[(len+1)/2];
      for(int i=lotto2.length-1; i>=0; i--){
      print(number);
      print((int)number%100);
       lotto2[i] =(int) number % 100;
       print(lotto2[i]);
       number/=100;
      }
      
      for(int i:lotto2)
      print(i);
  }
}
