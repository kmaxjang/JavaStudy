package com.ex06;

import java.util.HashSet;
import java.util.Set;

import static com.ex01.Massge.*;

public final class Server<T> {

  private Set<T> user;

  public Server() {
    user = new HashSet<>();
  }

  public boolean join(T player) {
    if (!user.isEmpty() && user.contains(player)) {
      return false;
    }
    user.add(player);
    print("Join"+player,false);
    return true;
  }
  
  public void logout(T player){
    if(user.contains(player)){
      user.remove(player);
       print("Logout"+player,false);
    }
  }
}
