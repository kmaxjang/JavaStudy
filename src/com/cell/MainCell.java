package com.cell;

public class MainCell {

  public int[] getRandomBox(int size) {
    int[] databox = new int[size];
    for (int i = 0; i < size; i++) {
      databox[i] = i + 1;
    }
    java.util.Random random = new java.util.Random();
    int change;
    for (int index = 0; index < size; index++) {
      change = random.nextInt(size);
      if (index != change) {
        databox[index] = databox[index] + databox[change];
        databox[change] = databox[index] - databox[change];
        databox[index] = databox[index] - databox[change];
      }
    }
    return databox;
  }

  public void print(int[] databox) {
    StringBuffer print = new StringBuffer();
    for (int i = 0; i < databox.length; i++) {
      print.append(String.format("[%03d] ", databox[i]));
      if ((i + 1) % 10 == 0) {
        print.append("\n");
      }
    }
    System.out.println(print);
  }

  public static void main(String[] args) {
    MainCell mc = new MainCell();
    int[] data = mc.getRandomBox(100);
    mc.print(data);
  }
}
