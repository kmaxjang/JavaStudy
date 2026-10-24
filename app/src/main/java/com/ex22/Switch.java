package com.ex22;

public interface Switch {

enum State{
  ON(true){
    void touch(Switch touch){
      touch.off();
    }
  },
  OFF(false){
    void touch(Switch touch){
      touch.on();
    }
  };
  
  private final boolean state;
  
  private State(boolean state){
    this.state = state;
  }
  
  public boolean state(){
    return state;
  }
  
  abstract void touch(Switch touch);
}

  default void touch(){
    state().touch(this);
  }

  void on();

  void off();

  State state();
}
