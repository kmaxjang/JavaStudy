package com.ex01;

import com.ex01.Config;
import com.ex01.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.ex01.Massge.*;

public final class Screen {

public final int line_x = Config.Board_X.value();
public final int line_y = Config.Board_Y.value();
public final int map_size = line_x * line_y;

public final String tile_background = Config.Tile_Background.value();
public final String tile_number = Config.Tile_Number.value();
public final String[] tile_movemark ={"🔳","❎️","✅️"};

public Pattern search = Pattern.compile("\\X"); // 유니코드 문자단위 필터
public Matcher board = search.matcher("");
//"[\\u203C-\\u3299]|[\\uD83C-\\uDBFF][\\uDC00-\\uDFFF]");

  private StringBuilder map_board = new StringBuilder(map_size);
  private StringBuilder map_screen = new StringBuilder(tile_number.substring(0, 30));

  private void setBackground() {
    map_board.delete(0, map_board.length());
    for (int b = 0; b < map_size; b++) {
      map_board.append(tile_background);
    }
  }

  private int start,line;
  public void draw() {
  start =0;
  line=0;
  map_screen.delete(30,map_screen.length());
  board.reset(map_board.toString());   
    for(int i =0; i< line_y;i++){
    map_screen.append("\n");
      line += 3;
      map_screen.append(tile_number.substring(line,line+3));
      for(int x=0; x<line_x;x++){
      board.find();
      }
      map_screen.append(map_board.substring(start,board.end()));     
      start = board.end();
    }
    System.out.println(map_screen);
  }

  public void piecePath(HashMap<Point,String> map) {
    for(Map.Entry<Point,String> entry :map.entrySet()){
      replace(entry.getKey(),entry.getValue());
    }
  }

  public void moveMark(Point point) {}

  public void removeMark() {}

  public void move(Point start, Point end) {}
  
  public String replace(Point point, String newchar) {
        int length = 0;
        board.reset(map_board.toString());
        while(length <= point.code){
          length++;
          board.find();
        }        map_board.replace(board.start(),board.end(),newchar);
        return board.group();
    }

public int charCount(int position){
int length =0;
int count =0;
int code=0;
  while(length < map_board.length()){
    code = map_board.codePointAt(length);
    if(count <= position){
      return length;
    }
    length += Character.charCount(code);
    count++;
  }
  return length;
}

public static String life(int n){
  StringBuilder life = new StringBuilder();
  n = Math.max(0, Math.min(n, 3));
  for(int i=0; i< 3;i++){
    life.append(n>i?Config.life: Config.life2);
  }
  return life.toString();
}
  public static void main(String[] args) {
//  int[] default_piecepath ={1200,1630,1650,1280,1141,1312,1372,1703,1723,1743,1763,1783,2706,2726,2746,2766,2786,2617,2657,2148,2209,2639,2659,2289};
  
    Screen screen = new Screen();
    screen.setBackground();
    screen.draw();
    for(int x=0; x<9; x++){
      screen.replace(Point.of(x+(9*5)),screen.tile_movemark[0]);
    screen.replace(Point.of(3+(x*9)),screen.tile_movemark[0]);
    }
    
    screen.replace(Point.of(0),screen.tile_movemark[2]);
    screen.replace(Point.of(55),screen.tile_movemark[0]);
    screen.draw();
    int count=0;
    
    Matcher matcher = screen.search.matcher(screen.tile_number);
    while(matcher.find()){
      count++;
      System.out.println("Start"+matcher.start()+" End"+matcher.end()+" Group"+matcher.group());
    }
    System.out.println("Count"+count);
    
    print("Massage");
    print(String.format("%s[%-10s]%s",Config.turn_on,"playerid",life(1)));
    
  }
}