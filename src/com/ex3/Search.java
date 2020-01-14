package com.ex3;

import java.util.Date;
import java.util.Random;

public class Search {

  private boolean flg = false;
  private long start;
  private long end;

  public void timer() {
    if (!flg) {
      start = System.currentTimeMillis();
      System.out.println("타이머 작동" + start);
      flg = true;
    } else {
      end = System.currentTimeMillis() - start;
      System.out.println("타이머 정지" + end);
      flg = false;
    }
  }

  // 정렬된 배열 절반씩 검색
  public int search(int[] data, int search) {
    int s = 0;
    int e = data.length;
    int m = 0;
    while (s != e) {
      m = (s + e) / 2;
      if (search == data[m]) {
        return m;
      }
      if (search < data[m]) {
        e = m;
      } else {
        s = m + 1;
      }
    }
    return -1;
  }
  // 정렬된 배열 델타평균으로 검색
  public int search(int[] data, long search) {

    int low = 0;
    int high = data.length - 1;

    long dlta;
    int mid;
    while (data[low] < search && data[high] > search) {
      dlta = (search - data[low]) * (high - low);
      System.out.printf("%d = (%d -%d)*(%d -%d)\n", dlta, search, data[low], high, low);
      mid = low + (int) (dlta / (data[high] - data[low]));
      System.out.println(mid);
      if (data[mid] < search) {
        low = mid + 1;
      } else if (data[mid] > search) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    if (data[low] == search) {
      return low;
    }
    if (data[high] == search) {
      return high;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] data = new int[10000000];
    data[0] = 100;
    Random seed = new Random();
    for (int i = 1; i < data.length; i++) {
      data[i] = data[i - 1] + seed.nextInt(100);
    }
    System.out.println("찾는수 위치" + data[10000]);
    Search s = new Search();
    s.timer();
    int p = s.search(data, data[10000]);
    s.timer();
    if (p != -1) System.out.println("찾는수 위치 data[" + p + "]=" + data[p]);

    s.timer();
    p = s.search(data, (long) data[10000]);
    s.timer();
    if (p != -1) System.out.println("찾는수 위치 data[" + p + "]=" + data[p]);
  }
}
