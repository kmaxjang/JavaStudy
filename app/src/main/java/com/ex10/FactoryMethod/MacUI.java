package com.ex10.FactoryMethod;

import com.ex10.FactoryMethod.UI;
import com.ex10.FactoryMethod.UIFactory;

public final class MacUI implements UIFactory {

  public UI getUI() {
    return new UI() {
      public void button() {
        System.out.println("Mac Button");
      }

      public void line() {
        System.out.println("Mac Line");
      }
    };
  }
}
