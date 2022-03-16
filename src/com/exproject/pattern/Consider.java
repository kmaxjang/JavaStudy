package com.exproject.pattern;

import com.exproject.pattern.State;


public class Consider{

private State state= new CloseState();

public void open(){
  state.open(this);
}

public void close(){
  state.close(this); 
}

public void setState(State s){
  state = s;
}

}
