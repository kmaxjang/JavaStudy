package com.ex17;

import java.util.Arrays;
import java.util.BitSet;

public class LottoIndex {

public static final int POINT = 6;
public static final int RANGE = 45;
public static final int TOTAL = countCombinations(RANGE,POINT);

 // 1차원 배열로 조합 결과 미리 계산
private static int[] result = new int[POINT * RANGE];
private static int[] result2 = new int[POINT*RANGE];
// static 초기화: 클래스 로딩 시 자동 계산
 static {
  buildResult();
 }
 
 // 조합 수 계산 (nCk)pCn
 public static int countCombinations(int p, int n) {
  if (n > p) return 0;
  if (n == 0 || n == p) return 1;

  int result = 1;
  for (int i = 1; i <= n; i++) {
   result = result * (p - i + 1) / i;
  }
  return result;
 }
 
 // getter 함수: 읽기 전용, 안전
public static int getResult(int p, int n) {
System.out.format("result[%02d, %02d] = %7d\n",p,n,result[p * RANGE + n]);
  return result[p * RANGE + n];
 }

 // 조합 테이블 초기화 (불변, 안전)
public static void buildResult() {
//원본
  for (int n = 0; n < RANGE; n++) {
  result[n] = 1;  
  }

  for (int p = 1; p < POINT; p++) {
   for (int n = p; n < RANGE; n++) {
    result[p* RANGE +n] = result[p*RANGE+n-1] + result[(p-1)*RANGE+n-1];
   }
  }
// 두번째 대안  
 for(int n =0; n < RANGE; n++){
   result2[(POINT-1)*RANGE +n]=1;
 }
  for(int n = 0; n < RANGE-1; n++){
for(int p = POINT-2; p >= 0; p--){
result2[p*RANGE+n+1] = result2[p*RANGE+n]+ result2[(p+1)*RANGE+n];
}
}

// 3번째 대안
int OPT = RANGE-POINT+1;
int[] result3 = new int[POINT*OPT];
for(int p=0; p < POINT; p++){
  result3[p*OPT] =1;
}
for(int n=1; n< OPT; n++){
  result3[(POINT-1)*OPT +n] =1;
}
for(int n=1; n <OPT; n++){
  for(int p=POINT-2; p >=0; p--){
    result3[p*OPT+n] = result3[p*OPT+n-1] +result3[(p+1)*OPT+n];
  }
}
int r =40,sum=0;
for(int n=0; n< OPT; n++ ){
  sum+=result3[n];
}
  //*
  StringBuilder msg = new StringBuilder();
  msg.append("조합 테이블 초기화 완료\n");
  for(int p=0; p< result.length;p++){
msg.append(String.format("[%7d]",result[p]));
if(p !=0 && p%(RANGE-1) == 0){
    msg.append(p);
    msg.append("\n");
    }
  }
  System.out.println(msg);
  //*/
 }

 // 로또 번호 -> 인덱스
 static int toIndex(int[] nums) {
  int index = 0;
  for (int p = 0,n =1; p < POINT; p++) {
   for(;n < nums[p];n++) {
    index += result[(POINT - p)*RANGE - n];    
   }
   System.out.format("index(%7d) : result[%d,%2d]\n",index, POINT-p, n);
   n = nums[p]+1;
  }
  return index;
 }
 
 static int toIndex2(int[] nums) {
// System.out.println(Arrays.toString(nums));
  int index = 0;
  for (int p = 0; p < POINT-1; p++) {
  if(nums[p+1]-nums[p] > 1){
    for(int i= nums[p]+1; i < nums[p+1]; i++){
      index += result2[(p+1)*RANGE+i];
    }
    System.out.format("index(%7d) : result[%d,%2d~%2d]\n",index,p, nums[p]+1,nums[p+1]-1);
  }
  }
  return index;
 }

 // 인덱스 -> 로또 번호 (오름차순)
 static int[] fromIndex(int index) {
 
  int[] nums = new int[POINT];
  int n = 1;
  for (int p = 0; p < POINT; p++) {
   while (result[(POINT - p)*RANGE- n] <= index) {
    index -= result[(POINT - p)*RANGE - n];
    n++;
   }
   nums[p] = n;
    n++;
  }
  return nums;
 }

 // 사전식 다음 조합 생성
 static boolean nextCombination(int[] nums) {
  for (int p = POINT - 1; p >= 0; p--) {
   if (nums[p] < RANGE - POINT + p + 1) {
    nums[p]++;
    for (int j = p + 1; j < POINT; j++){
     nums[j] = nums[j - 1] + 1;
     }
    return true;
   }
  }
  return false;
 }
 
 // 조합을 long으로 압축 (6bit * 6 = 36bit)
 static long pack(int[] nums) {
  long value = 0;
  for (int n : nums) {
   value = (value << 6) | n;
  }
  return value;
 }

 // 압축 해제
 static int[] unpack(long value) {
  int[] nums = new int[POINT];
  for (int i = POINT - 1; i >= 0; i--) {
   nums[i] = (int)(value & 63);
   value >>= 6;
  }
  return nums;
 }


 public static void main(String[] args) {

  BitSet bitset = new BitSet(TOTAL);
  bitset.set(10);
  /*
  StringBuilder msg = new StringBuilder();
  msg.append(String.format("예상 전체조합: %d",TOTAL));
  
  long start = System.currentTimeMillis();
int[] nums;  
int count = 0;
  do {
  nums = fromIndex(count);
   int idx = toIndex(nums);   
   if (toIndex(fromIndex(idx)) != count) {
    msg.append(String.format("불일치 발견!\n count[%7d] != toIndex[%7d]\n nums[%s]\n",count,idx,Arrays.toString(nums)));
    break;
   }
   // 진행 출력 (샘플)
   if (count % 1000000 == 0) msg.append(String.format("Count(%7d) %7d -> %-24s\n",count,idx, Arrays.toString(nums)));
   count++;
  } while (nextCombination(nums));

  long end = System.currentTimeMillis();

  msg.append(String.format("생성한 조합 수: %d\n",count));
  msg.append(String.format("BitSet Size(%d)\n",bitset.size()));
  msg.append(String.format("BitSet Length(%d)\n", bitset.length()));
  msg.append(String.format("시간(%dms)\n", (end - start)));
  System.out.println(msg);
//*/
  // 소수 역변환 샘플 출력
  for (int i = 1086008; i < 1086015; i++) {
  int[] nums = fromIndex(i);
  
   System.out.println("idx " + toIndex(fromIndex(i)) + " -> " + Arrays.toString(fromIndex(i)));
  }
  
  int[] lotto= {1,2,3,4,5,7};
  int total=0;
  for(int k=0; k < POINT; k++ ){
    total += getResult(k, lotto[k]);
    countCombinations(k,lotto[k]);
  }
  System.out.println(total);
 }
}