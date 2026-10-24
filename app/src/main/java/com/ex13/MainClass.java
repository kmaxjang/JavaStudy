package com.ex13;

import com.ex13.Top;
import com.ex13.TopClass;

public final class MainClass {

  public static void msg(String msg) {
    System.out.println(msg);
  }

  public static void main(String[] args) {
    msg("Java Ex13 2025.06.01");
    
    Top top = new TopClass("topclass");
    msg(top.name());
    msg(top.path());
    msg("Size"+top.size());
    msg("Totalsize"+top.totalSize());
  }
}
