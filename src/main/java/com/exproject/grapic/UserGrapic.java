package com.exproject.grapic;
// 그래픽 외부 인터페이스 구현
public class UserGrapic implements DefaultDrive{

private Grapics gp =null;
  public String draws() {
    return "내마음대로 그림";
  }

  public String getDriveName() {
    return "베타 그래픽 ver 0.1";
  }
  
  public DefaultDrive getOutside(Grapics gp){
    System.out.println("========================\n"+gp.marker());
    return this;
  }
}
