package com.game.janggi.ex5;

public enum PieceName {
  Cha(15,2),
  Poo(5,3),
  Ma(4,4),
  Sang(3,5),
  Sa(3,6),
  jol(1,7),
  King(0,1);

  private int score;
  private int code;

  private PieceName(int score, int code) {
    this.score = score;
    this.code = code;
  }

  public int getScore() {
    return score;
  }
  
  public int getCode(){
    return code;
  }
}
