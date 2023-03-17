package com.game.janggi.ex3.game;

public class Msg {

private final static int line = 30;

  public static void print(String... msg) {
    if (msg == null) {
      System.out.print("Null Error");
      return;
    }
    for (String m : msg) {
      if (m.length() > line) {
       int l = m.length();
       for(int s = 0, e = line; l> 0;){
        System.out.println(m.substring(s, e));
        s = e;
        l-=line;
        e = (l > line)? e + line: e + l;
// System.out.println("Length"+l+" start"+s+" end"+ e);
       }
     }else{
      System.out.println(m);
      }
    }
  }


}
