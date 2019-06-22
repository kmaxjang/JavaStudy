package com.bighits;

public class ByteClass {

  private long number = 0l;
  private int length = 0;

  public void setChange(int num, int point) {

    long tmp = number, p = (long) Math.pow(100, point - 1);
    tmp = tmp - getSimple(point) * p;
    tmp = tmp + num * p;
    System.out.println(
        "orginal : "
            + number
            + "\nchange  : "
            + tmp
            + "p"
            + p
            + "n"
            + getSimple(point)
            + "c"
            + (num * p));
    long ex = 1234567890;
    for (int c = 1; c < 7; c++) {
      System.out.println("" + ex % (long) Math.pow(100, c));
      System.out.println("" + ex / (long) Math.pow(100, c));
      long ev = (long) Math.pow(100, c);
      System.out.println(" " + ex % ev / (ev / 100));
    }
  }

  public void setInteger(long number) {
    this.number = number;
  }

  public void setInteger(int number) {
    if (!limet(number)) return;
    if (7 > length) {
      this.number = (this.number * 100) + number;
      length++;
    }
    System.out.printf("😎Integer :%10d(Byte :%10x)%n", number, number);
    System.out.println(Integer.toBinaryString(number));
  }

  public long getInteger() {

    return number;
  }

  public int get(int point) {

    if (point <= length) {
      long tmp = number, num = 0;
      for (int c = 1; c <= point; c++) {
        num = tmp % 100;
        tmp = tmp / 100;
      }
      return (int) num;
    }

    return 0;
  }

  public int getSimple(int point) {
    long tmp = number;
    if (point != 1) {
      tmp = tmp / (long) Math.pow(100, point - 1);
    }
    return (int) (tmp % 100);
  }

  private boolean CompareSort(int num) {
    if (length == 0) {
      number = num;
      length++;
      return true;
    }
    long tmp = number;
    long point = (long) Math.pow(100, length);
    for (int count = 0; count < length; count++) {
      if (tmp % point == num) {
        return false;
      } else if (tmp % 100 > num) {
        number = tmp * 100 + num;
        length++;
      }
    }
    return true;
  }

  private boolean limet(int num) {
    return (num <= 0 || num >= 46) ? false : true;
  }
}
