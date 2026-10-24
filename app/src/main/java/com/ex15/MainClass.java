package com.ex15;

import com.ex15.RealDoor;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    print("ex15 2025.08.19");
    RealDoor door = new RealDoor(null);
    print(door.isOpenDoor());
    door.closed();
    print(door.isOpenDoor());
  }
}
