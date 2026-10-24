package com.ex17;

import com.ex17.Consecutive;
import com.ex17.OddEven;
import java.util.Arrays;
import static com.ex01.Massge.*;
import static com.ex17.LottoIndex.*;

public final class MainClass {

static final int LOOP = 100_000_000; // 1억 번

static String app1(int loop){
 long start = System.nanoTime();
  int n=0;
  for (int i = 0; i < loop; i++) {
   n++;
  }
long end = System.nanoTime();
return String.format("N++   RunTime[%4.1f]ms %d\n",((end-start)/1_000_000.0),n);
}

static String app2(int loop){
 long start = System.nanoTime();
  int n=0;
  for (int i = 0; i < loop; i++) {
   n+=1;
  }
long end = System.nanoTime();
return String.format("N+=1  RunTime[%4.1f]ms %d\n",((end-start)/1_000_000.0),n);
}

static String app3(int loop){
 long start = System.nanoTime();
  int n=0;
  for (int i = 0; i < loop; i++) {
   n= n+1;
  }
long end = System.nanoTime();
return String.format("N=n+1 RunTime[%4.1f]ms %d\n",((end-start)/1_000_000.0),n);
}

  public static void main(String[] args) {
    int[] numbers = new int[] {1, 3, 5, 6, 7, 9};
    Consecutive c = new Consecutive();
    print("연속번호" + c.accept(numbers));
    // 5, 4
    OddEven oe = new OddEven();
    print("홀짝 " + oe.accept(numbers));
    
    // *
    for (int i = 0; i < 8145060; i++) {
      int[] nums = fromIndex(i);
      int index = toIndex(nums);
      int index2 = toIndex(fromIndex(index));
      if (index != index2) {
        print(index + "----실패---" + index2);
        print(fromIndex(i));
        print(fromIndex(index));
        break;
      }
    }
    int[] count = new int[40];
    for(int i=0; i<8145060; i++){ 
   int[] tmp = fromIndex(i);
   count[tmp[0]-1]++;
   }
 print(Arrays.toString(count));
 
  StringBuilder sb = new StringBuilder();
  sb.append("===== Increment Speed Test =====\n");
 sb.append(app1(LOOP));
 sb.append(app2(LOOP));
 sb.append(app3(LOOP));
 sb.append("=======\n");
 sb.append(app2(LOOP-100));
 sb.append(app3(LOOP-100));
 sb.append(app1(LOOP-100));
sb.append("=======\n");
sb.append(app3(LOOP-200));
 sb.append(app1(LOOP-200));
 sb.append(app2(LOOP-200));


  // ====== 단 한 번만 콘솔 출력 ======
  System.out.print(sb.toString());
    print("종료");
    // */
  }
}
