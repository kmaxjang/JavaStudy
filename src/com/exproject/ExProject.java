package com.exproject;

import com.exproject.grapic.*;

public class ExProject {

  public static void scr(String tt) {
    System.out.println(tt);
  }

  public static void main(String[] args) {

    Grapics gg = Grapics.getDrive();
    if (gg != null) {
      scr(gg.marker());
    }
    gg = Grapics.getDrive();
    if (gg != null) {
      scr(gg.marker());
    }
    Grapics.installed(new UserGrapic());
    gg = Grapics.getDrive();
    if (gg != null) {
      scr(gg.marker());
    }
    Grapics.installed(null);
    gg = Grapics.getDrive();
    if (gg != null) {
      scr(gg.marker());
    }
  }
}
