package com.ex06;

import java.util.Objects;

public class Player {
  private final String name;

  private final int hashcode;

  public Player(String name) {
    this.name = name;
    hashcode = Objects.hash(name);
  }

  public String name() {
    return name;
  }

  public boolean equals(Object object) {
    if (object instanceof Player) {
      Player player = (Player) object;
      return name.equals(player.name());
    }
    return false;
  }

  public int hashCode() {
    return hashcode;
  }

  public String toString() {
    return "["+name+"]";
  }
}
