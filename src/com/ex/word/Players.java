package com.ex.word;

import com.ex.word.Data;

public abstract class Players {

private boolean team = true; 
private String name;

private boolean turn = false;
public Data data;

public Players(String name){
  this.name = name;
}

public String getName(){
  return name;
}

public boolean getTeam(){
  return team;
}

public void setTeam(boolean team){
  this.team = team;
  turn = !team;
}

public boolean turnEnd(){
  return turn;
}

public void playTrun(int playturn){
  
}
  public abstract int updata();
  
  public abstract void load(Data data);

  public abstract void drow();
}