package com.ex10.FactoryMethod;

import com.ex10.FactoryMethod.UIFactory;

public final class Client {

  private UIFactory uif;

  public Client() {
    uif = UIFactory.defaultUI;
  }

  public void setUI(UIFactory uif) {
    this.uif = uif;
  }

  public void button() {
    uif.getUI().button();
  }

  public void line() {
    uif.getUI().line();
  }
}
