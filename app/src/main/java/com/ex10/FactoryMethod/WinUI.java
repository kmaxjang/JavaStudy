package com.ex10.FactoryMethod;

import com.ex10.FactoryMethod.UI;
import com.ex10.FactoryMethod.UIFactory;

public final class WinUI implements UIFactory {

  public UI getUI() {
    return new UI() {
      public void button() {
        System.out.println("Win Button");
      }

      public void line() {
        System.out.println("Win Line");
      }
    };
  }
}
