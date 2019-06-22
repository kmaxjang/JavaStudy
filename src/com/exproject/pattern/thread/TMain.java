package com.exproject.pattern.thread;

import java.util.ArrayList;
import java.util.List;

public class TMain implements Runnable {

  private List<Guest> guest = new ArrayList<Guest>();
  private boolean exit = false;

  public void run() {}

  public void newGuest(String name) {
    guest.add(new Guest(name));
  }

  public boolean exit() {
    if (guest.isEmpty()) {
      return false;
    }
    for (Guest g : guest) {
      exit = g.exit();
      if(!exit){
        return false;
      }
    }
    return exit;
  }

  public static void main(String[] args) {
    TMain tm = new TMain();
    tm.newGuest("Han");
    tm.newGuest("Cho");
    tm.newGuest("Guest");
    
    try {
    String numstr = "1234567";
    String[] sp = numstr.split("");
      while (tm.exit()) {
        Thread.sleep(1000);
        for(String num: sp){
          System.out.println(num);
        }
      }

    } catch (Exception e) {

    }
    System.out.println("메인종료");
  }
}
