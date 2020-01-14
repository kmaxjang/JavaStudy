package com.ex4;

import com.ex4.land.Land;

public class MainClass {

  public static void main(String[] args) {

    Land land = Land.getInstent();
    
    try{
      Thread.sleep(10*1000);
    }catch (Exception e){
      
    }
  }
}
