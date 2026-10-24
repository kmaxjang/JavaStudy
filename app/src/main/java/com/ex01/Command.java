package com.ex01;

public enum Command {
  // {"한수쉼", "기권패", "시간패", "점수패", "외통패", "접속끈김"};
  TURNOVER("한수쉼",3100000),
  GIVEUP("기권",3400000),
  TIMEOVER("시간초과",3200000),
  SCOREOFF("점수",3300000),
  CHECKMATE("외통",3500000),
  DISCONNECTED("접속끊김",3600000);

  private final String str;
  private final int code;

  private Command(String str,int code) {
    this.str = str;
    this.code = code;
  }
  
  public int code(){
    return code;
  }
  
  public String msg(){
    return str;
  }
}
