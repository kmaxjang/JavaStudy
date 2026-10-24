package com.ex17;

import java.util.BitSet;

public interface Filter {
  default BitSet buildBitSet(int size, boolean value) {
    BitSet bitset = new BitSet(size);
    if (value) {
      bitset.set(0, size);
    } else {
      bitset.clear(0, size);
    }
    return bitset;
  }
  
  boolean accept(int[] numbers);
}

class Consecutive implements Filter {

  // 4자리 이상 연속번호면 true
  public boolean accept(int[] numbers) {
    int count = 1;
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] - numbers[i - 1] == 1) {
        count++;
        if (count >= 4) return true;
      } else {
        if (i >= 2) break;
        count = 1;
      }
    }
    return false;
  }
}

class OddEven implements Filter {

  // 6자리 모두 홀수또는 짝수 이면 true
  public boolean accept(int[] numbers) {
    boolean parity = numbers[0] % 2 != 0;
    for (int i = 1; i < numbers.length; i++) {
      if ((numbers[i] % 2 != 0) != parity) {
        return false;
      }
    }
    return true;
  }
}

class WinningNumbers implements Filter {

  private BitSet winninglist;

  public WinningNumbers(BitSet list) {
    winninglist = list;
  }

  public boolean accept(int[] numbers) {
    return false;
  }
}
