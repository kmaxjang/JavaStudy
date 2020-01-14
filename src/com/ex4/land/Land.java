package com.ex4.land;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public final class Land {

  private static Land land = null;
  private Thread thread =
      new Thread(
          new Runnable() {
            public void run() {
              while (true) {
                try {
                  Thread.sleep(5000);
                //  break;
                  for (Link l : list) {
                     if(l.isUpdate()){
                       l.update(null);
                     }                         
                  }
                  for (Link l : list) {
                    l.draw();
                  }
                } catch (Exception e) {

                }
              }
            }
          });

  private List<Link> list = new ArrayList<Link>();

  private Land() {
    thread.start();
  }

  public static Land getInstent() {
    if (land == null) {
      land = new Land();
    }
    return land;
  }
}
