package com.ex03;

import com.ex03.LadderGame;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    print("2024.12.20 Ex03");
    LadderGame game = new LadderGame(5);
    
    print(game.chose(4));
  }
}
