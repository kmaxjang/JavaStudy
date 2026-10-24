package com.ex01;
/*
group> cho:1 han: 2
pieceSet> cha: 7 poo: 6 ma: 5 sang: 4 sa: 3 jol: 2 king: 1
point> 0~89, 00 ~ 89
command> 30000000~
 
*/
public interface Code {
  
  static <T extends Code> T decode(T[] map, int code){
  return map[code];
 }
 
  int code();
  
}
