package com.ex07;

import com.ex07.Queue;

public final class MainClass {

  public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    q.input("a");
    q.input("b");
    q.input("c");
    q.setFrontMode(DequeMode.Queue);
    int count = 10;
    while (!q.isEmpty()) {
      System.out.println(q.output()+count);
      if (count > 0) {
        q.input("add" + count);
        count--;
      }
    }
  }
}
