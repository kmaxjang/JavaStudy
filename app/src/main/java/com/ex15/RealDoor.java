package com.ex15;

import com.ex15.Door;

public class RealDoor {

  private Door door = Door.CLOSED;
  
  public RealDoor(Door door){
    if(door != null){
      this.door = door;
    }
  }

  public boolean isOpenDoor() {
    return door.isOpenDoor();
  }

  public void open() {
    door = door.open();
  }

  public void closed() {
    door = door.closed();
  }
}
