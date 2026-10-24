package com.ex01;

/** 8방향 좌표 이동 표준 */
public enum Direction {
  UP(0, -1), // North
  UPRIGHT(1, -1), // NorthWest
  RIGHT(1, 0), // West
  DOWNRIGHT(1, 1), // SouthWest
  DOWN(0, 1), // South
  DOWNLEFT(-1, 1), // SouthEast
  LEFT(-1, 0), // East
  UPLEFT(-1, -1); // NorthEast

  // 캐싱된 배열 ─ values()는 새 배열을 복사하므로 한 번만 호출
  private static final Direction[] DIRS = values();

  public final int dx; // x 이동량
  public final int dy; // y 이동량

  Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  /** 정반대 방향 */
  public Direction reverse() {
    return DIRS[(ordinal() + 4) & 7]; // & 7 == % 8
  }

  /** 시계 방향 */
  public Direction cw() {
    return DIRS[(ordinal() + 1) & 7];
  }

  /** 반시계 방향 */
  public Direction ccw() {
    return DIRS[(ordinal() + 7) & 7];
  }

  /** 임의 각도 회전 (offset:0~7 8방향) */
  public Direction spin(int offset) {
    // ((offset % 8) + 8) % 8  과 동일: 음수 안전
    int rot = (offset & 7); // 0‥7 로 정규화
    return DIRS[(ordinal() + rot) & 7];
  }

  // ────── 4방향 유틸 ──────
  /** 4방향(직선) : 0=UP, 1=RIGHT, 2=DOWN, 3=LEFT */
  public static Direction orthogonal(int index) {
    return DIRS[(index & 3) << 1]; // (index % 4) * 2
  }

  /** 4방향(대각선) : 0=UPRIGHT, 1=DOWNRIGHT, 2=DOWNLEFT, 3=UPLEFT */
  public static Direction diagonal(int index) {
    return DIRS[((index & 3) << 1) + 1];
  }
}
