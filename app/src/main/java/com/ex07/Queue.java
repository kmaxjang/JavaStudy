package com.ex07;

import com.ex07.DequeMode;
import java.util.ArrayList;
import java.util.List;

/*
Mode
Queue FIFO true
Stack LIFO false
*/

public final class Queue<T> {

  private List<T> datalist = new ArrayList<>();

  private volatile DequeMode mode;

  public Queue() {
    setFrontMode(DequeMode.Stack);
  }

  public void input(T data) {
    datalist.add(data);
  }

  public T output() {
    return mode.output(datalist);
  }

  public T peek() {
    return mode.peek(datalist);
  }

  public boolean isEmpty() {
    return datalist.isEmpty();
  }

  public int size() {
    return datalist.size();
  }

  public String mode() {
    return mode.name();
  }

  public void setFrontMode(DequeMode mode) {
    this.mode = mode;
  }
}
