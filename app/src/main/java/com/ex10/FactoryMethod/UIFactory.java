package com.ex10.FactoryMethod;

import com.ex10.FactoryMethod.UI;

public interface UIFactory {

  UIFactory defaultUI = new WinUI();

  UI getUI();
}
