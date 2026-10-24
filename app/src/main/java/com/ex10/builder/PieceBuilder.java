package com.ex10.builder;

public abstract class PieceBuilder implements Builder<Piece> {

public PieceBuilder(){
  
}

public PieceBuilder setGroup(String group){
  return this;
}

  public final Piece build() {
    return null;
  }
}
