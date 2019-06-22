package com.bighits;

import java.nio.ByteBuffer;
import java.nio.file.*;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

public class Lotto {

  public void setPlus(int num) {
    scr("구구단을 외자 " + num + "단!");
    for (int a = 1; a <= 9; a++) {
      scr(num + "×" + a + "=" + (num * a));
    }
  }

  public void setPrme() {
    int num = 0, count = 0;
    for (int a = 1; a <= 10; a++) {
      // scr(""+a);
      for (int b = a - 1; b >= 2; b--) {
        if (a % b == 0) {
          break;
        } else if (b == 2) {
          count++;
          scr("소수" + a);
        }
      }
      num = a;
    }
    scr("" + num + "사이 소수 갯수" + count);
  }

  public void setAngel(int layer) {
    int x = layer;
    StringBuffer str = new StringBuffer();
    do {

      for (int a = 0; a <= layer; a++) {
        str.append(" ");
      }
      for (int b = 0; b <= (x - layer); b++) {
        str.append("☆");
      }
      str.append("\n");

    } while ((layer--) > 0);

    scr(str.toString());
  }

  public static void scr(String msg) {
    System.out.println(msg);
  }

  public static void main(String[] args) {
    /*
       System.out.println("Hello Jang");
       Lotto lotto = new Lotto();
       lotto.setPlus(9);
       lotto.setPrme();
       lotto.setAngel(11);
       scr("종료");
       Type.INT.set(new Integer(100));
       scr(""+(Integer)Type.INT.get());
    */
    /*
    FileSystem fs =FileSystems.getDefault();
    for(FileStore st: fs.getFileStores()){

    scr("드라이브명"+ st.name());
    scr("파일시스템"+ st.type());
    try{
    scr("전체공간"+ st.getTotalSpace());
    scr("사용중 공간");
    }catch(Exception e){

    }
    }
    */

    ByteClass bc = new ByteClass();
    bc.setInteger(46);
    bc.setInteger(44);
    bc.setInteger(43);
    bc.setInteger(42);
    bc.setInteger(41);
    bc.setInteger(40);
    bc.setInteger(0);
    bc.setChange(2, 2);
    scr("" + 0 % 100);

    scr(
        "================"
            + bc.getInteger()
            + "\npoint"
            + bc.get(1)
            + "\nsimple"
            + bc.getSimple(3));

    int[] in = {1, 2, 14, 56, 45, 14, 11, 26, 33,4,17,19,23,34,42,39,27,18,3,4,6};
    Numbers nums = new Numbers();
    nums.setNumber(5);
    nums.deleteNumber(5);
    nums.setNumber(in);
    nums.deleteNumber(2);
    nums.changeNumber(1,44);
    nums.change(45444342414039L);

    int[] bak = nums.getNumbers();
    if (bak == null) {
      scr("null 등록번호 없다");
    } else {
      for (int i = 0; i < bak.length; i++)
        System.out.println("Limet" + nums.getLimet() + " " + bak.length + " " + bak[i]+"  "+nums.change());
    }
    
//    Chain.getChain().link(0);
    ByteBuffer bb = ByteBuffer.allocate(1024);
    scr(bb.toString());
  }
}
