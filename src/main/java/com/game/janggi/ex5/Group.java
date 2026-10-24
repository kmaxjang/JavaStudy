package com.game.janggi.ex5;

public enum Group {
  Han(10),
  Cho(20);
  
  private int code;

  private Group(int code) {    
    this.code = code;
  }
  
  public int getCode(){
    return code;
  }
  
  public Group getTurn(){
    switch(this){
      case Han: return Cho;
      case Cho: return Han;
    }
    return null;
  }
}
