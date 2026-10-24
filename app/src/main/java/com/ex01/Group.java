package com.ex01;

import com.ex01.Code;

/** Piece 의 요소 */
public enum Group implements Code {
  HAN,
  CHO;

  public static final Group[] MAP = values();

  public boolean isHAN() {
    return this == HAN;
  }

  public Group enemy() {
    return (this == HAN) ? CHO : HAN;
  }

  @Override
  public int code() {
    return ordinal();
  }

  public static Group of(int code) {
    return MAP[code];
  }
}
