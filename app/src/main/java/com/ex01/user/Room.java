package com.ex01.user;

import com.ex01.user.Player;
import java.util.HashSet;
import java.util.Set;

public class Room {

  public static final Room room = new Room();

  private Player[] gameplayer = new Player[2];
  private Set<Player> playerlist;

  private Room() {
    playerlist = new HashSet();
  }

  public void add(Player player) {
    playerlist.add(player);
  }
}
