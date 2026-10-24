package com.ex16;

import com.ex16.Player;
import java.util.ArrayList;
import java.util.List;

/**
플레이어들에게
*/

public class Room {

private List<Player> list = new ArrayList<>();

  public Room() {
    //
  }
  
  public boolean join(Player player){
    return list.add(player);
  }
}
