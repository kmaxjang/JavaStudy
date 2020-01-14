package com.ex2.tool;

public enum Group {
  PLANT("식물"),
  HERBIVORE("초식동물"),
  CARNIVORE("육식동물");

  private String group;

  private Group(String group) {
    this.group = group;
  }

  public String toString() {
    return group;
  }
}
