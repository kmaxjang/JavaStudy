package com.ex16;

import com.ex16.Player;
import com.ex16.Room;
import java.util.HashSet;
import java.util.Set;

public final class Player {

  private static Set<String> namelist = new HashSet<>();

  private String name;

  private Player(String name) {
    this.name = name;
  }

  public static Player join(String name, Room room) {
    if (name == null || name.toLowerCase() == "null" || room == null) {
      throw new NullPointerException("not be null");
    }
    if(!namelist.contains(name)){
      namelist.add(name);
      Player player = new Player(name);
      room.join(player);
      return player;
    }
    return new Player(name);
  }

  public String name() {
    return name;
  }

  public boolean logout() {
    return namelist.remove(name);
  }
}
