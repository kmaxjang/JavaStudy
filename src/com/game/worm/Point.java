package com.game.worm;
// 좌표기역
public class Point {

  public int x;
  public int y;
  // 기본 생성자
  public Point() {
    this(0, 0);
  }
  // 포인트 생성자
  public Point(Point p) {
    this(p.x, p.y);
  }
  // 수동좌표 생성자
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  // 이동좌표
  public void move(int mx, int my) {
    x = x + mx;
    y = y + my;
  }
  // 이동포인트
  public void move(Point mp) {
    move(mp.x, mp.y);
  }
  // 설정좌표
  public void set(int sx, int sy) {
    x = sx;
    y = sy;
  }
  // 설정포인트
  public void set(Point sp) {
    set(sp.x, sp.y);
  }
  // 좌표복제
  public Point get() {
    return new Point(this);
  }
  
  public String toString(){
    return "["+x+","+y+"]";
  }
}
