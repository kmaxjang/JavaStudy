package com.cell;

import java.util.Random;

public class Search {

  private boolean flg = false;
  private long start;

  public void timer() {
    if (!flg) {
      start = System.nanoTime();
      System.out.println("타이머 작동");
      flg = true;
    } else {
      long elapsed = System.nanoTime() - start;
      System.out.println("타이머 정지 " + elapsed / 1_000_000.0 + " ms");
      flg = false;
    }
  }

  // 정렬된 배열 절반씩 검색
  public int search(int[] data, int search) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int start = 0;
    int end = data.length - 1;

    while (start <= end) {
      int index = start + (end - start) / 2;

      if (search == data[index]) {
        return index;
      }

      if (search < data[index]) {
        end = index - 1;
      } else {
        start = index + 1;
      }
    }

    return -1;
  }

  // 정렬된 배열에서 값의 위치를 추정하여 검색하는 보간 탐색
  public int search(int[] data, long search) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int low = 0;
    int high = data.length - 1;

    while (low <= high
        && search >= data[low]
        && search <= data[high]) {

      if (data[low] == data[high]) {
        return data[low] == search ? low : -1;
      }

      long delta = (search - (long) data[low]) * (high - low);
      long range = (long) data[high] - data[low];
      int mid = low + (int) (delta / range);

      if (data[mid] < search) {
        low = mid + 1;
      } else if (data[mid] > search) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] data = new int[10_000_000];
    data[0] = 100;

    Random seed = new Random();
    for (int i = 1; i < data.length; i++) {
      data[i] = data[i - 1] + seed.nextInt(100);
    }

    int target = data[10_000];

    Search s = new Search();

    System.out.println("찾는수 위치 " + target);

    s.timer();
    int p = s.search(data, target);
    s.timer();
    if (p != -1) {
      System.out.println("이진 탐색 결과 data[" + p + "]=" + data[p]);
    }

    s.timer();
    p = s.search(data, (long) target);
    s.timer();
    if (p != -1) {
      System.out.println("보간 탐색 결과 data[" + p + "]=" + data[p]);
    }
  }
}
