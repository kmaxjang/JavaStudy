package com.ex19;

import static com.ex01.Massge.*;
import com.ex19.Command;
import com.ex19.ComPass;
import com.ex19.ComGiveUpGame;
import com.ex19.ComMove;

public class Board {

  public void Command(Command cmd) {
    if (cmd != null) {
      if (cmd instanceof ComMove) {
        ComMove cm = (ComMove) cmd;
        print(cm.getPiece() +" "+ cm.getMovePoint());
      } else if (cmd instanceof ComPass) {
        print("한수쉼");
      } else if (cmd instanceof ComGiveUpGame) {
        print("기권");
      }
    }
  }
}
