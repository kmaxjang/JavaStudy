package com.exproject.grapic;

import com.exproject.grapic.Default;
import com.exproject.grapic.Grapics;
// 그래픽 드라이브 반환
public abstract class Grapics {

  protected static DefaultDrive dd = null;
  private static Grapics gp = null;

  public static Grapics getDrive() {
    if (gp == null) {
      gp = new Default();
    }
    return gp;
  }

  public static void installed(DefaultDrive outside) {
    if (outside != null) {
      dd = outside;
      gp = new Outside();
      dd.getOutside(gp);
    }else {
      dd = null;
      gp = null;
    }
  }

  public abstract String draws();

  public abstract String getDriveName();

  public String marker() {
    return getDriveName() + "\n" + draws();
  }
}
// 기본 그래픽 구현
class Default extends Grapics {

  private int count = 0;

  public String draws() {
    count++;
    return "기본 그림이다" + count;
  }

  public String getDriveName() {
    return "Default Drive ver 1.0";
  }
}
// 외부 그래픽 구현
class Outside extends Grapics {

  public String draws() {
    return dd.draws();
  }

  public String getDriveName() {
    return dd.getDriveName();
  }
}
