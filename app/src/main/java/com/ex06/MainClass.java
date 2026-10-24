package com.ex06;

import com.ex06.Server;
import static com.ex01.Massge.*;

public final class MainClass {

  public static void main(String[] args) {
    print("java ex06 2024.12.07");
    Server<Player> server = new Server<>();
    print(server.join(new Player("jang")));
    print(server.join(new Player("jan")));
    print(server.join(new Player("ja")));
    print(server.join(new Player("jang")));
    
  }
}
