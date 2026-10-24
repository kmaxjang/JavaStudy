package com.game.janggi;

import java.util.Set;

import com.game.janggi.ex2.tool.Point;
import com.game.janggi.ex2.tool.Way;
import com.game.janggi.ex5.Room;
import com.game.janggi.ex5.Screen;

public final class MainClass {

  public static void msg(String msg) {
    System.out.println(msg);
  }

  public static int result(int x, int y) {
    return (x / 30) + y;
  }

  public static void main(String[] args) {

    msg("자바연습 시작");
    Point p = new Point(1, 1);
    Way.set(p);
    Way.RIGHT.move();
    msg(Way.DOWN.move().toString());
    Way.LEFTDOWN.move();
    msg(Way.UP.toString());
    msg(p.toString());

    msg("마");
    Way.set(p);
    Way.UP.move();
    Way.RIGHTUP.move();
    Way.LEFT.move();
    Way.UP.move(Way.UP, Way.DOWN, Way.DOWN, Way.LEFT);
    msg(Way.UP.toString());

int min, max;
int row,column;
// min = max - row
// max = min + row
// row = max
    int up, down;
    int input = 49, result = 0;
    up = input / 10;
    down = input % 10;
    msg("up" + up + " down" + down);

    result = (up * 10) + down;

    msg("result" + result);
    msg("++ " + result(10, 10));
    msg("+- " + result(10, -10));
    msg("-+ " + result(-10, 10));
    msg("-- " + result(-10, -10));

    Point point = new Point();
    
    Room room = new Room(null, null);
    Set<Integer> keyset = room.piece_path.keySet();    
    
    Screen screen = new Screen();
    screen.background();
    
    for(Integer key: keyset) {
    	msg("Key :"+key);
    	msg("Velue :"+room.piece_path.get(key));    	
    	point.set(key/8, key%8);
    	screen.asmble(point.get(),room.piece_path.get(key));
    }    
    
    msg("종료");
  }
}
/*
speed 1

시간
거리
프레임 60
fps

*/
