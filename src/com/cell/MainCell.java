package com.cell;

public class MainCell {

  public static void msg(String msg) {
    System.out.println(msg);
  }

  public int[] setRandomBox(int size) {
    int[] databox = new int[size];
    for (int i = 0; i < size; i++) {
      databox[i] = i + 1;
    }
    java.util.Random random = new java.util.Random();
    int change;
    for (int i = 0; i < size; i++) {
      change = random.nextInt(size);
      if (i != change) {
        databox[i] = databox[i] + databox[change];
        databox[change] = databox[i] - databox[change];
        databox[i] = databox[i] - databox[change];
      }
    }
    return databox;
  }

  public void print(int[] databox) {
    StringBuffer print = new StringBuffer();
    print.append("DataBox\n");
    for (int i = 0; i < databox.length; i++) {
      print.append(String.format("[%03d] ", databox[i]));
      if ((i + 1) % 10 == 0) {
        print.append("\n");
      }
    }
    print.append("End");
    System.out.println(print);
  }

  public static void main(String[] args) {
    msg("자바 연습");
    MainCell mc = new MainCell();
    int[] data = mc.setRandomBox(100);
    mc.print(data);
  }
}
