package com.game.janggi.ex.interfacemod;

import java.util.Iterator;
import com.game.janggi.ex.interfacemod.MoveChose
import com.game.janggi.ex.ex1.Board;

public interface PieceMove {

  public Iterator<MoveChose> moveable(Board board);
}
