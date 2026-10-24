package com.ex22;

import static com.ex01.Massge.*;

import com.ex22.Switch;
import com.ex22.StrikeNumber;

public final class MainClass {

  public static void main(String[] args) {
    print("Java Ex22 2026-06-06");

    Switch oneswitch =
        new Switch() {
          private volatile State plan = State.OFF;

          public State state() {
            return plan;
          }

          public void on() {
            plan = State.ON;
            print("switch on");
          }

          public void off() {
            plan = State.OFF;
            print("switch off");
          }
        };
        

    print("Switch state: " + oneswitch.state());
    oneswitch.touch();
    print("Switch state: " + oneswitch.state());
    oneswitch.touch();
    print("Switch state: " + oneswitch.state());
    
   StrikeNumber sn = StrikeNumber.create(1,2,3);
   StrikeNumber sn2 = StrikeNumber.create(3,1,4);
   
   print(sn.judgment(sn2));
  }
}
