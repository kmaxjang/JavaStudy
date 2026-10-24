package com.ex10.Singleton;

public final class Singleton {

  private static Singleton instance = null;
  private String msg;

  private Singleton(String msg) {
    this.msg = msg;
  }

  public static Singleton getInstance(String msg) {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton(msg);
        }
      }
    }
    return instance;
  }
  
  public String toString(){
    return msg;
  }
}
