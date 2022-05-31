package com.ex2.word;

import com.ex2.tool.Point;
import com.ex2.tool.Group;
import com.ex2.word.Influence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Land {
  private static Land instanse = null;
  private Point size = new Point(20, 25);
  private int destory = 100;
  private List<Influence> objectlist = new ArrayList<Influence>();
  private Thread thread;

  public Land() {
    thread =
        new Thread(
            new Runnable() {
              public void run() {
                System.out.println("타이머 작동");
                while (destory >= 0) {
                  try {
                    time();
                    Thread.sleep(100);
                    destory--;
                    screen();
                  } catch (Exception e) {

                  }
                }
              }
            });
    thread.start();
  }

  public void addObject(Influence object) {
    objectlist.add(object);
  }

  public static Land getInstanse() {
    if (instanse == null) {
      System.out.println("Land 생성");
      instanse = new Land() {};
    }
    return instanse;
  }

  private void time() {
    Iterator<Influence> it = objectlist.iterator();
    while (it.hasNext()) {
      Influence deliver = it.next();
      if (deliver.death()) {
        System.out.println("사망" + deliver.info());
        it.remove();
      } else {
        deliver.time();
      }
    }
  }

  public void screen() {
    StringBuffer sb = new StringBuffer();
    //1~10 숫자표시
    for (int x = 0; x <= size.x; x++) {
      sb.append(image(x % 10));
    }
    sb.append("\n");
    int s = sb.length();
    // 첫자리 숫자 나머지 배경
    for (int y = 1; y <= size.y; y++) {
      sb.append(image(y % 10));
      for (int linex = 0; linex < size.x; linex++) {
        sb.append(image(14));
      }
      sb.append("\n");
    }
    // 첫라인 64 첫행 3 Size x19,y24
    // 좌표공식 67 + x +(24 * y)
    int po = 0;
    for (Influence deliver : objectlist) {
      Point p = deliver.getPoint();
      po = 67 + p.x + (24 * p.y);
      switch (deliver.getGroup()) {
        case PLANT:
          sb.replace(po, po+1, image(11));
          break;
        case HERBIVORE:
          sb.replace(po, po+1, image(12));
          break;
        case CARNIVORE:
          sb.replace(po, po+1, image(13));
          break;
      }
    }
    System.out.print(sb);
  }

// 이미지 맵 크기 1~9:3 10~13:2 14:1
  StringBuffer image_map = new StringBuffer("0️⃣1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣🔟🌲🐰🐯⬛");

  private String image(int p) {
    if (p <= 9) {
      return image_map.substring(3 * p, 3 * p + 3);
    } else if (p <= 13) {
      return image_map.substring(2 * p + 10, 2 * p + 10 + 2);
    }
      return image_map.substring(p + 24, p + 24 + 1);
  }
}
